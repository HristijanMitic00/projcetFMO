package project.fmo.app.projcetfmo.Model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Entity
@Table(schema = "project", name = "korisnik",  catalog = "db_202223z_va_prj_fmo")
public class Korisnik implements UserDetails {
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


    public Korisnik(){

    }
    public Korisnik(String imePrezime, String passwordKorisnik, Timestamp kreiranNaDatum) {
        this.imePrezime = imePrezime;
        this.passwordKorisnik = passwordKorisnik;
        this.kreiranNaDatum = kreiranNaDatum;
    }

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
