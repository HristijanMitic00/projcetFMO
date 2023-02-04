package model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class TelefonskibrojPK implements Serializable {
    @Column(name = "id_korisnik")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKorisnik;
    @Column(name = "telefonski_broj")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String telefonskiBroj;

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
