package model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class CenaPK implements Serializable {
    @Column(name = "id_produkt")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProdukt;
    @Column(name = "cena_od")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date cenaOd;

    public int getIdProdukt() {
        return idProdukt;
    }

    public void setIdProdukt(int idProdukt) {
        this.idProdukt = idProdukt;
    }

    public Date getCenaOd() {
        return cenaOd;
    }

    public void setCenaOd(Date cenaOd) {
        this.cenaOd = cenaOd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CenaPK cenaPK = (CenaPK) o;
        return idProdukt == cenaPK.idProdukt && Objects.equals(cenaOd, cenaPK.cenaOd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdukt, cenaOd);
    }
}
