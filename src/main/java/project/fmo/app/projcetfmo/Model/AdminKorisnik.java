package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "admin_korisnik", schema = "project", catalog = "db_202223z_va_prj_fmo")
public class AdminKorisnik {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_korisnik")
    private int idKorisnik;

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
        AdminKorisnik that = (AdminKorisnik) o;
        return idKorisnik == that.idKorisnik;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnik);
    }
}
