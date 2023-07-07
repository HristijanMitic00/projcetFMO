package project.fmo.app.projcetfmo.Service;

import project.fmo.app.projcetfmo.Model.Korisnik;

public interface AuthService {
    Korisnik login(String username, String password);
}
