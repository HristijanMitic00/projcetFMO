package project.fmo.app.projcetfmo.Model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class TelefonskibrojPK implements Serializable {
    @Column(name = "id_korisnik")
    @Id
    private int idKorisnik;
    @Column(name = "telefonski_broj")
    @Id
    private String telefonskiBroj;


    public TelefonskibrojPK(){

    }
    public TelefonskibrojPK(int idKorisnik, String telefonskiBroj) {
        this.idKorisnik = idKorisnik;
        this.telefonskiBroj = telefonskiBroj;
    }

    public int getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(int idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public String getTelefonskiBroj() {
        return telefonskiBroj;
    }

    public void setTelefonskiBroj(String telefonskiBroj) {
        this.telefonskiBroj = telefonskiBroj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefonskibrojPK that = (TelefonskibrojPK) o;
        return idKorisnik == that.idKorisnik && Objects.equals(telefonskiBroj, that.telefonskiBroj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnik, telefonskiBroj);
    }
}
