package model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class ProduktEOdKategorijaPK implements Serializable {
    @Column(name = "id_produkt")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProdukt;
    @Column(name = "id_kategorija")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKategorija;

    public int getIdProdukt() {
        return idProdukt;
    }

    public void setIdProdukt(int idProdukt) {
        this.idProdukt = idProdukt;
    }

    public int getIdKategorija() {
        return idKategorija;
    }

    public void setIdKategorija(int idKategorija) {
        this.idKategorija = idKategorija;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProduktEOdKategorijaPK that = (ProduktEOdKategorijaPK) o;
        return idProdukt == that.idProdukt && idKategorija == that.idKategorija;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdukt, idKategorija);
    }
}
