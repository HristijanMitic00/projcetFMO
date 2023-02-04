package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Kategorija {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_kategorija")
    private int idKategorija;
    @Basic
    @Column(name = "ime")
    private String ime;

    public int getIdKategorija() {
        return idKategorija;
    }

    public void setIdKategorija(int idKategorija) {
        this.idKategorija = idKategorija;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kategorija that = (Kategorija) o;
        return idKategorija == that.idKategorija && Objects.equals(ime, that.ime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKategorija, ime);
    }
}
