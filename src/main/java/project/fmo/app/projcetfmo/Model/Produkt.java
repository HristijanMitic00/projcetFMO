package project.fmo.app.projcetfmo.Model;

import javax.persistence.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.Objects;

@Entity
@Table(schema = "project", name = "produkt",  catalog = "db_202223z_va_prj_fmo")
public class Produkt {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_produkt")
    private int idProdukt;
    @Basic
    @Column(name = "ime")
    private String ime;
    @Basic
    @Column(name = "opis")
    private String opis;

    @ManyToOne
    @JoinColumn(name = "id_korisnik")
    private AdminKorisnik adminKorisnik;

    public Produkt(){}

    public Produkt(String ime, String opis, AdminKorisnik adminKorisnik) {
        this.ime = ime;
        this.opis = opis;
        this.adminKorisnik = adminKorisnik;
    }

    public int getIdProdukt() {
        return idProdukt;
    }

    public void setIdProdukt(int idProdukt) {
        this.idProdukt = idProdukt;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getIdKorisnik() {
        return adminKorisnik.getIdKorisnik();
    }

    public void setIdKorisnik(AdminKorisnik idKorisnik) {
        this.adminKorisnik = idKorisnik;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produkt produkt = (Produkt) o;
        return idProdukt == produkt.idProdukt && adminKorisnik == produkt.adminKorisnik && Objects.equals(ime, produkt.ime) && Objects.equals(opis, produkt.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdukt, ime, opis, adminKorisnik);
    }
}
