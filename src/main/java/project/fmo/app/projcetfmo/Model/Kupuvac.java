package project.fmo.app.projcetfmo.Model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema = "project", name = "kupuvac",  catalog = "db_202223z_va_prj_fmo")
public class Kupuvac {

    @Id
    @Column(name = "id_korisnik")
    private int idKorisnik;
    @Basic
    @Column(name = "mail")
    private String mail;

    public Kupuvac(int idKorisnik, String mail) {
        this.idKorisnik=idKorisnik;
        this.mail=mail;
    }

    public Kupuvac() {
    }

    public int getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(int idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kupuvac kupuvac = (Kupuvac) o;
        return idKorisnik == kupuvac.idKorisnik && Objects.equals(mail, kupuvac.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnik, mail);
    }
}
