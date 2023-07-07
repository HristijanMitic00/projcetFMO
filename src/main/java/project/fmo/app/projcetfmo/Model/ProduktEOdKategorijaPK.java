package project.fmo.app.projcetfmo.Model;

import javax.persistence.*;


import java.io.Serializable;
import java.util.Objects;

public class ProduktEOdKategorijaPK implements Serializable {
    @Column(name = "id_produkt")
    @Id
    private int idProdukt;
    @Column(name = "id_kategorija")
    @Id

    private int idKategorija;


    public ProduktEOdKategorijaPK(){}
    public ProduktEOdKategorijaPK(int idProdukt, int idKategorija) {
        this.idKategorija=idKategorija;
        this.idProdukt=idProdukt;
    }

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
