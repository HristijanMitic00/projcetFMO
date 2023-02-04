package model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Naracka {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_naracka")
    private int idNaracka;
    @Basic
    @Column(name = "vkupno_suma")
    private int vkupnoSuma;
    @Basic
    @Column(name = "datum")
    private Date datum;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "adresa")
    private String adresa;
    @Basic
    @Column(name = "id_korisnik")
    private int idKorisnik;

    public int getIdNaracka() {
        return idNaracka;
    }

    public void setIdNaracka(int idNaracka) {
        this.idNaracka = idNaracka;
    }

    public int getVkupnoSuma() {
        return vkupnoSuma;
    }

    public void setVkupnoSuma(int vkupnoSuma) {
        this.vkupnoSuma = vkupnoSuma;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

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
        Naracka naracka = (Naracka) o;
        return idNaracka == naracka.idNaracka && vkupnoSuma == naracka.vkupnoSuma && idKorisnik == naracka.idKorisnik && Objects.equals(datum, naracka.datum) && Objects.equals(status, naracka.status) && Objects.equals(adresa, naracka.adresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNaracka, vkupnoSuma, datum, status, adresa, idKorisnik);
    }
}
