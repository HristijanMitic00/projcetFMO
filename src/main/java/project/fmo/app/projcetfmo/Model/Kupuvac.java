package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Kupuvac {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_korisnik")
    private int idKorisnik;
    @Basic
    @Column(name = "mail")
    private String mail;

    public int getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(int idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kupuvac kupuvac = (Kupuvac) o;
        return idKorisnik == kupuvac.idKorisnik && Objects.equals(mail, kupuvac.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnik, mail);
    }
}
