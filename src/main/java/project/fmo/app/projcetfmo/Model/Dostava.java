package model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Dostava {
    @Basic
    @Column(name = "id_korisnik")
    private int idKorisnik;
    @Basic
    @Column(name = "id_naracka")
    private int idNaracka;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_dostava")
    private int idDostava;
    @Basic
    @Column(name = "datum")
    private Date datum;
    @Basic
    @Column(name = "status")
    private String status;

    public int getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(int idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public int getIdNaracka() {
        return idNaracka;
    }

    public void setIdNaracka(int idNaracka) {
        this.idNaracka = idNaracka;
    }

    public int getIdDostava() {
        return idDostava;
    }

    public void setIdDostava(int idDostava) {
        this.idDostava = idDostava;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dostava dostava = (Dostava) o;
        return idKorisnik == dostava.idKorisnik && idNaracka == dostava.idNaracka && idDostava == dostava.idDostava && Objects.equals(datum, dostava.datum) && Objects.equals(status, dostava.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnik, idNaracka, idDostava, datum, status);
    }
}
