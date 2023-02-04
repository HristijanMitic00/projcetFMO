package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "produkt_e_vo_magacin", schema = "project", catalog = "db_202223z_va_prj_fmo")
@IdClass(ProduktEVoMagacinPK.class)
public class ProduktEVoMagacin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_produkt")
    private int idProdukt;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_magacin")
    private int idMagacin;
    @Basic
    @Column(name = "kolicina")
    private int kolicina;

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

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProduktEVoMagacin that = (ProduktEVoMagacin) o;
        return idProdukt == that.idProdukt && idMagacin == that.idMagacin && kolicina == that.kolicina;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdukt, idMagacin, kolicina);
    }
}
