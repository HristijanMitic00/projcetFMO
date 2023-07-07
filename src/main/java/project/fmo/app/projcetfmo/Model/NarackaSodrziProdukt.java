package project.fmo.app.projcetfmo.Model;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "naracka_sodrzi_produkt", schema = "project", catalog = "db_202223z_va_prj_fmo")
@IdClass(NarackaSodrziProduktPK.class)
public class NarackaSodrziProdukt {
    @Id
    @Column(name = "id_produkt")
    private int idProdukt;
    @Id
    @Column(name = "id_naracka")
    private int idNaracka;
    @Basic
    @Column(name = "kolicina")
    private int kolicina;
    @Basic
    @Column(name = "cena")
    private int cena;

    public NarackaSodrziProdukt(){}

    public NarackaSodrziProdukt(int idProdukt, int idNaracka, int kolicina, int cena) {
        this.idProdukt = idProdukt;
        this.idNaracka = idNaracka;
        this.kolicina = kolicina;
        this.cena = cena;
    }

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

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NarackaSodrziProdukt that = (NarackaSodrziProdukt) o;
        return idProdukt == that.idProdukt && idNaracka == that.idNaracka && kolicina == that.kolicina && cena == that.cena;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdukt, idNaracka, kolicina, cena);
    }
}
