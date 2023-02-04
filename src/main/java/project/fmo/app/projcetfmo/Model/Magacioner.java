package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Magacioner {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_korisnik")
    private int idKorisnik;
    @Basic
    @Column(name = "id_magacin")
    private int idMagacin;

    public int getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(int idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public int getIdMagacin() {
        return idMagacin;
    }

    public void setIdMagacin(int idMagacin) {
        this.idMagacin = idMagacin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magacioner that = (Magacioner) o;
        return idKorisnik == that.idKorisnik && idMagacin == that.idMagacin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnik, idMagacin);
    }
}
