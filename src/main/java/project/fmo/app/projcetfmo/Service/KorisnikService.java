package project.fmo.app.projcetfmo.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import project.fmo.app.projcetfmo.Model.Korisnik;
import project.fmo.app.projcetfmo.Repository.KorisnikRepository;

import java.sql.Date;
import java.util.List;

public interface KorisnikService extends UserDetailsService {
    Korisnik findbyImePrezime (String ime);
    Korisnik findById(Integer id);
    Korisnik register(String username, String password, String repeatPassword, String mail, String number);

    List<Object> statistics2();
}
