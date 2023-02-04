package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Produkt {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_produkt")
    private int idProdukt;
    @Basic
    @Column(name = "ime")
    private String ime;
    @Basic
    @Column(name = "opis")
    private String opis;
    @Basic
    @Column(name = "id_korisnik")
    private int idKorisnik;

    public int getIdProdukt() {
        return idProdukt;
    }

    public void setIdProdukt(int idProdukt) {
        this.idProdukt = idProdukt;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
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
        Produkt produkt = (Produkt) o;
        return idProdukt == produkt.idProdukt && idKorisnik == produkt.idKorisnik && Objects.equals(ime, produkt.ime) && Objects.equals(opis, produkt.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdukt, ime, opis, idKorisnik);
    }
}
