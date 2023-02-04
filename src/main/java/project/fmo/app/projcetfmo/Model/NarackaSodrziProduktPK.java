package model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class NarackaSodrziProduktPK implements Serializable {
    @Column(name = "id_produkt")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProdukt;
    @Column(name = "id_naracka")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNaracka;

    public int getIdProdukt() {
        return idProdukt;
    }

    public void setIdProdukt(int idProdukt) {
        this.idProdukt = idProdukt;
    }

    public int getIdNaracka() {
        return idNaracka;
    }

    public void setIdNaracka(int idNaracka) {
        this.idNaracka = idNaracka;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NarackaSodrziProduktPK that = (NarackaSodrziProduktPK) o;
        return idProdukt == that.idProdukt && idNaracka == that.idNaracka;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdukt, idNaracka);
    }
}
