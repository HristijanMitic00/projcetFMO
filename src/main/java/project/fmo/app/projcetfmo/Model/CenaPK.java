package project.fmo.app.projcetfmo.Model;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class CenaPK implements Serializable {
    @Column(name = "id_produkt")
    @Id
    private int idProdukt;
    @Column(name = "cena_od")
    @Id
    private Date cenaOd;

    public CenaPK (){}
    public CenaPK(Integer idProdukt, Date cenaOd) {
        this.idProdukt = idProdukt;
        this.cenaOd = cenaOd;
    }

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
