package model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Korisnik {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_korisnik")
    private int idKorisnik;
    @Basic
    @Column(name = "ime_prezime")
    private String imePrezime;
    @Basic
    @Column(name = "password_korisnik")
    private String passwordKorisnik;
    @Basic
    @Column(name = "kreiran_na_datum")
    private Timestamp kreiranNaDatum;

    public int getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(int idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getPasswordKorisnik() {
        return passwordKorisnik;
    }

    public void setPasswordKorisnik(String passwordKorisnik) {
        this.passwordKorisnik = passwordKorisnik;
    }

    public Timestamp getKreiranNaDatum() {
        return kreiranNaDatum;
    }

    public void setKreiranNaDatum(Timestamp kreiranNaDatum) {
        this.kreiranNaDatum = kreiranNaDatum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Korisnik korisnik = (Korisnik) o;
        return idKorisnik == korisnik.idKorisnik && Objects.equals(imePrezime, korisnik.imePrezime) && Objects.equals(passwordKorisnik, korisnik.passwordKorisnik) && Objects.equals(kreiranNaDatum, korisnik.kreiranNaDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnik, imePrezime, passwordKorisnik, kreiranNaDatum);
    }
}
