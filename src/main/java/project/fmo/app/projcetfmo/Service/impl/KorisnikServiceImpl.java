package project.fmo.app.projcetfmo.Service.impl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.fmo.app.projcetfmo.Model.*;
import project.fmo.app.projcetfmo.Repository.*;
import project.fmo.app.projcetfmo.Service.KorisnikService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final PasswordEncoder passwordEncoder;
    private final AdminRepository adminRepository;
    private final DostavuvacRepository dostavuvacRepository;

    private final TelefnoskiBrojRepository telefnoskiBrojRepository;
    private final KupuvacRepository kupuvacRepository;
    private final KorisnikRepository korisnikRepository;

    public KorisnikServiceImpl(PasswordEncoder passwordEncoder, AdminRepository adminRepository, DostavuvacRepository dostavuvacRepository, TelefnoskiBrojRepository telefnoskiBrojRepository, KupuvacRepository kupuvacRepository, KorisnikRepository korisnikRepository) {
        this.passwordEncoder = passwordEncoder;
        this.adminRepository = adminRepository;
        this.dostavuvacRepository = dostavuvacRepository;
        this.telefnoskiBrojRepository = telefnoskiBrojRepository;
        this.kupuvacRepository = kupuvacRepository;
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Korisnik korisnik = korisnikRepository.findByImePrezime(username);
        for (AdminKorisnik a: adminRepository.findAll()) {
            if (a.getIdKorisnik() == korisnik.getIdKorisnik()) {
                return new User(korisnik.getImePrezime(), korisnik.getPasswordKorisnik(), Stream.of(new SimpleGrantedAuthority("ROLE_ADMIN")).collect(Collectors.toList()));
            }
        }
        for (Dostavuvac a: dostavuvacRepository.findAll()) {
            if (a.getIdKorisnik() == korisnik.getIdKorisnik()) {
                return new User(korisnik.getImePrezime(), korisnik.getPasswordKorisnik(), Stream.of(new SimpleGrantedAuthority("ROLE_DELIVER")).collect(Collectors.toList()));
            }
        }
        for (Kupuvac a: kupuvacRepository.findAll()){
            if (a.getIdKorisnik() == korisnik.getIdKorisnik()){
                return new User(korisnik.getImePrezime(),korisnik.getPasswordKorisnik(), Stream.of(new SimpleGrantedAuthority("ROLE_USER")).collect(Collectors.toList()) );
            }
        }
        return null;
    }

    @Override
    public Korisnik findbyImePrezime(String ime) {
        return korisnikRepository.findByImePrezime(ime);
    }

    @Override
    public Korisnik findById(Integer id) {
        return korisnikRepository.findById(id).orElse(null);
    }

    @Override
    public Korisnik register(String username, String password, String repeatPassword, String mail, String number) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new RuntimeException();
        if (!password.equals(repeatPassword))
            throw new RuntimeException();

        Korisnik korisnik = new Korisnik(username,password, Timestamp.valueOf(LocalDateTime.now()));
        korisnikRepository.save(korisnik);
        Kupuvac k = new Kupuvac(korisnik.getIdKorisnik(), mail);
        kupuvacRepository.save(k);
        Telefonskibroj t = new Telefonskibroj(new TelefonskibrojPK(korisnik.getIdKorisnik(),number));
        telefnoskiBrojRepository.save(t);
        return korisnik;

    }

    @Override
    public List<Object> statistics2() {
        return korisnikRepository.statistics2();
    }
}
