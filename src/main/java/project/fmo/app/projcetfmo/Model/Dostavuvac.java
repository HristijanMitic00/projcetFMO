package project.fmo.app.projcetfmo.Model;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(schema = "project", name = "dostavuvac",  catalog = "db_202223z_va_prj_fmo")
public class Dostavuvac {

    @Id
    @Column(name = "id_korisnik")
    private int idKorisnik;

    public Dostavuvac(){}

    public int getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(int idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dostavuvac that = (Dostavuvac) o;
        return idKorisnik == that.idKorisnik;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnik);
    }
}
