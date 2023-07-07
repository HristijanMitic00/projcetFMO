package project.fmo.app.projcetfmo.Model;

import project.fmo.app.projcetfmo.Service.impl.DostavaServiceImpl;

import javax.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(schema = "project", name = "dostava",  catalog = "db_202223z_va_prj_fmo")
public class Dostava {
    @ManyToOne
    @JoinColumn(name = "id_korisnik")
    private Dostavuvac dostavuvac;
    @OneToOne
    @JoinColumn(name = "id_naracka")
    private Naracka naracka;
    @Id
    @Column(name = "id_dostava")
    private int idDostava;
    @Basic
    @Column(name = "datum")
    private Date datum;
    @Basic
    @Column(name = "status")
    private String status;

    public Dostava (){}

    public Dostava(Dostavuvac dostavuvac, Naracka naracka, int idDostava, Date datum, String status) {
        this.dostavuvac = dostavuvac;
        this.naracka = naracka;
        this.idDostava = idDostava;
        this.datum = datum;
        this.status = status;
    }

    public int getIdKorisnik() {
        return dostavuvac.getIdKorisnik();
    }

    public void setIdKorisnik(int idKorisnik) {
        this.dostavuvac.setIdKorisnik(idKorisnik);
    }

    public int getIdNaracka() {
        return naracka.getIdNaracka();
    }

    public void setIdNaracka(int idNaracka) {
        this.naracka.setIdNaracka(idNaracka);
    }

    public int getIdDostava() {
        return idDostava;
    }

    public void setIdDostava(int idDostava) {
        this.idDostava = idDostava;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dostava dostava = (Dostava) o;
        return dostavuvac == dostava.dostavuvac && naracka == dostava.naracka && idDostava == dostava.idDostava && Objects.equals(datum, dostava.datum) && Objects.equals(status, dostava.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dostavuvac, naracka, idDostava, datum, status);
    }
}
