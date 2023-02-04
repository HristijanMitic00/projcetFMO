package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(TelefonskibrojPK.class)
public class Telefonskibroj {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_korisnik")
    private int idKorisnik;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "telefonski_broj")
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
        Telefonskibroj that = (Telefonskibroj) o;
        return idKorisnik == that.idKorisnik && Objects.equals(telefonskiBroj, that.telefonskiBroj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnik, telefonskiBroj);
    }
}
