package project.fmo.app.projcetfmo.Model;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(schema = "project", name = "telefonskibroj",  catalog = "db_202223z_va_prj_fmo")
@IdClass(TelefonskibrojPK.class)
public class Telefonskibroj {

    @Id
    @Column(name = "id_korisnik")
    private int idKorisnik;

    @Id
    @Column(name = "telefonski_broj")
    private String telefonskiBroj;

    public Telefonskibroj(){}

    public Telefonskibroj(TelefonskibrojPK telefonskibrojPK) {
        this.idKorisnik = telefonskibrojPK.getIdKorisnik();
        this.telefonskiBroj = telefonskibrojPK.getTelefonskiBroj();
    }

    public int getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(int idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public String getTelefonskiBroj() {
        return telefonskiBroj;
    }

    public void setTelefonskiBroj(String telefonskiBroj) {
        this.telefonskiBroj = telefonskiBroj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefonskibroj that = (Telefonskibroj) o;
        return idKorisnik == that.idKorisnik && Objects.equals(telefonskiBroj, that.telefonskiBroj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnik, telefonskiBroj);
    }
}
