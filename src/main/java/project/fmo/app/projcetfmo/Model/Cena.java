package project.fmo.app.projcetfmo.Model;

import javax.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(schema = "project", name = "cena",  catalog = "db_202223z_va_prj_fmo")
@IdClass(CenaPK.class)
public class Cena {
    @Id
    @Column(name = "id_produkt")
    private int  idProdukt;
    @Id
    @Column(name = "cena_od")
    private Date cenaOd;
    @Basic
    @Column(name = "cena_do")
    private Date cenaDo;
    @Basic
    @Column(name = "iznos")
    private int iznos;

    public Cena(){}
    public Cena(int idProdukt, Date cenaOd, Date cenaDo, int iznos) {
        this.idProdukt = idProdukt;
        this.cenaOd = cenaOd;
        this.cenaDo = cenaDo;
        this.iznos = iznos;
    }

    public Cena(int idProdukt, Date cenaOd, int iznos) {
        this.idProdukt = idProdukt;
        this.cenaOd = cenaOd;
        this.iznos = iznos;
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

    public Date getCenaDo() {
        return cenaDo;
    }

    public void setCenaDo(Date cenaDo) {
        this.cenaDo = cenaDo;
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cena cena = (Cena) o;
        return idProdukt == cena.idProdukt && iznos == cena.iznos && Objects.equals(cenaOd, cena.cenaOd) && Objects.equals(cenaDo, cena.cenaDo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdukt, cenaOd, cenaDo, iznos);
    }
}
