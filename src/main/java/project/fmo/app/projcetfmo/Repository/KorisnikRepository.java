package project.fmo.app.projcetfmo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.fmo.app.projcetfmo.Model.Korisnik;

import java.util.List;

public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
    Korisnik findByImePrezime(String s);
    Korisnik findByImePrezimeAndPasswordKorisnik(String s, String p);

    @Query(value ="select k.id_korisnik,k.ime_prezime,\n" +
            "\n" +
            "(select count(n) from project.naracka as n\n" +
            "where n.id_korisnik  = k.id_korisnik)\n" +
            "as vkupno_naracki, \n" +
            "\n" +
            "(select avg(vkupno_suma) from project.naracka )\n" +
            "as prosecna_suma_na_naracka_za_site_kupuvaci,\n" +
            "\n" +
            "(select sum(n3.vkupno_suma) from project.naracka as n3 \n" +
            "where k.id_korisnik = n3.id_korisnik) \n" +
            "as vkupno_suma_od_site_naracki_na_kupuvacot,\n" +
            "\n" +
            "(select count(n2) from project.naracka as n2\n" +
            "where k.id_korisnik = n2.id_korisnik \n" +
            "and n2.datum between now() - interval '1year'  and now() \n" +
            "and n2.vkupno_suma > (select avg(vkupno_suma) from project.naracka) )\n" +
            "as vkupno_naracki_nad_prosek_na_korisnikot,\n" +
            "\n" +
            "(select sum(n4.vkupno_suma) from project.naracka as n4 \n" +
            "where  k.id_korisnik = n4.id_korisnik \n" +
            "and n4.datum between now() - interval '1year' and now() \n" +
            "and n4.vkupno_suma > (select avg(vkupno_suma) from project.naracka) ) \n" +
            "as vkupno_suma_na_naracki_nad_prosek_za_korisnikot\n" +
            "\n" +
            "from project.korisnik as k \n" +
            "inner join project.kupuvac as  k2 on k.id_korisnik = k2.id_korisnik \n" +
            "group by k.ime_prezime,k.id_korisnik ;" ,
    nativeQuery = true)
    List<Object> statistics2();
}
