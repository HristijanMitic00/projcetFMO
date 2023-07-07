package project.fmo.app.projcetfmo.Model;

import javax.persistence.*;


import java.io.Serializable;
import java.util.Objects;

public class ProduktEVoMagacinPK implements Serializable {
    @Column(name = "id_produkt")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProdukt;
    @Column(name = "id_magacin")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMagacin;

    public int getIdProdukt() {
        return idProdukt;
    }

    public void setIdProdukt(int idProdukt) {
        this.idProdukt = idProdukt;
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
        ProduktEVoMagacinPK that = (ProduktEVoMagacinPK) o;
        return idProdukt == that.idProdukt && idMagacin == that.idMagacin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdukt, idMagacin);
    }
}
