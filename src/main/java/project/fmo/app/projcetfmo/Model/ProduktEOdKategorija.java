package project.fmo.app.projcetfmo.Model;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "produkt_e_od_kategorija", schema = "project", catalog = "db_202223z_va_prj_fmo")
@IdClass(ProduktEOdKategorijaPK.class)
public class ProduktEOdKategorija {
    @Id
    @Column(name = "id_produkt")
    private int idProdukt;
    @Id
    @Column(name = "id_kategorija")
    private int idKategorija;

    public ProduktEOdKategorija(int idProdukt, int idKategorija) {
        this.idProdukt = idProdukt;
        this.idKategorija = idKategorija;
    }

    public ProduktEOdKategorija() {
    }

    public ProduktEOdKategorija(ProduktEOdKategorijaPK produktEOdKategorijaPK) {
        this.idKategorija= produktEOdKategorijaPK.getIdKategorija();
        this.idProdukt=produktEOdKategorijaPK.getIdProdukt();
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
        ProduktEOdKategorija that = (ProduktEOdKategorija) o;
        return idProdukt == that.idProdukt && idKategorija == that.idKategorija;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdukt, idKategorija);
    }
}
