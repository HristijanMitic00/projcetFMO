package project.fmo.app.projcetfmo.Model;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(schema = "project", name = "magacin",  catalog = "db_202223z_va_prj_fmo")
public class Magacin {

    @Id
    @Column(name = "id_magacin")
    private int idMagacin;
    @Basic
    @Column(name = "lokacija")
    private String lokacija;

    public int getIdMagacin() {
        return idMagacin;
    }

    public void setIdMagacin(int idMagacin) {
        this.idMagacin = idMagacin;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magacin magacin = (Magacin) o;
        return idMagacin == magacin.idMagacin && Objects.equals(lokacija, magacin.lokacija);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMagacin, lokacija);
    }
}
