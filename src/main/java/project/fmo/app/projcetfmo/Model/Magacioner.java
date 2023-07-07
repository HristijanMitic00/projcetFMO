package project.fmo.app.projcetfmo.Model;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(schema = "project", name = "magacioner",  catalog = "db_202223z_va_prj_fmo")
public class Magacioner {
    @Id
    @Column(name = "id_korisnik")
    private int idKorisnik;
    @ManyToOne
    @JoinColumn(name = "id_magacin")
    private Magacin magacin;

    public int getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(int idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public Magacin getMagacin() {
        return magacin;
    }

    public void setMagacin(Magacin magacin) {
        this.magacin = magacin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magacioner that = (Magacioner) o;
        return idKorisnik == that.idKorisnik && magacin == that.magacin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnik, magacin);
    }
}
