package project.fmo.app.projcetfmo.Model;

import javax.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(schema = "project", name = "naracka",  catalog = "db_202223z_va_prj_fmo")
public class Naracka {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_naracka")
    private int idNaracka;
    @Basic
    @Column(name = "vkupno_suma")
    private int vkupnoSuma;
    @Basic
    @Column(name = "datum")
    private Date datum;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "adresa")
    private String adresa;
    @ManyToOne
    @JoinColumn(name = "id_korisnik")
    private Kupuvac kupuvac;

    public Naracka(){}

    public Naracka(int vkupnoSuma, Date datum, String status, String adresa, Kupuvac kupuvac) {
        this.vkupnoSuma = vkupnoSuma;
        this.datum = datum;
        this.status = status;
        this.adresa = adresa;
        this.kupuvac = kupuvac;
    }

    public int getIdNaracka() {
        return idNaracka;
    }

    public void setIdNaracka(int idNaracka) {
        this.idNaracka = idNaracka;
    }

    public int getVkupnoSuma() {
        return vkupnoSuma;
    }

    public void setVkupnoSuma(int vkupnoSuma) {
        this.vkupnoSuma = vkupnoSuma;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getIdKorisnik() {
        return kupuvac.getIdKorisnik();
    }

    public void setIdKorisnik(int idKorisnik) {
        this.kupuvac.setIdKorisnik(idKorisnik);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Naracka naracka = (Naracka) o;
        return idNaracka == naracka.idNaracka && vkupnoSuma == naracka.vkupnoSuma && kupuvac == naracka.kupuvac && Objects.equals(datum, naracka.datum) && Objects.equals(status, naracka.status) && Objects.equals(adresa, naracka.adresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNaracka, vkupnoSuma, datum, status, adresa, kupuvac);
    }
}
