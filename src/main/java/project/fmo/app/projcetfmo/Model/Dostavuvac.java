package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Dostavuvac {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_korisnik")
    private int idKorisnik;

    public int getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(int idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dostavuvac that = (Dostavuvac) o;
        return idKorisnik == that.idKorisnik;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnik);
    }
}
