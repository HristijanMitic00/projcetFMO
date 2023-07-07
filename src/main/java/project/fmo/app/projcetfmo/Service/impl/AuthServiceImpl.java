package project.fmo.app.projcetfmo.Service.impl;

import org.springframework.stereotype.Service;
import project.fmo.app.projcetfmo.Model.Korisnik;
import project.fmo.app.projcetfmo.Repository.KorisnikRepository;
import project.fmo.app.projcetfmo.Service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final KorisnikRepository korisnikRepository;

    public AuthServiceImpl(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public Korisnik login(String username, String password) {
        return korisnikRepository.findByImePrezimeAndPasswordKorisnik(username,password);
    }
}
