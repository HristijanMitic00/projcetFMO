package project.fmo.app.projcetfmo.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.fmo.app.projcetfmo.Model.Produkt;

import java.util.List;

public interface ProduktRepository extends JpaRepository<Produkt, Integer> {
    @Query(value = """
            select p.id_produkt,p.ime,\s
            count(nsp) as broj_na_naracki_vo_koi_e_prisuten_produktot,\s
            sum(nsp.kolicina) as kolicina_prodadeno_od_produktot,\s

            (select avg(n4.vkupno_suma) from project.naracka as n4\s
            join project.naracka_sodrzi_produkt nsp4 on n4.id_naracka = nsp4.id_naracka \s
            where n4.id_naracka =nsp4.id_naracka and p.id_produkt = nsp4.id_produkt and n4.datum between now() - interval '3months'\s
            and now())
            as prosecna_suma_na_naracka_vo_koja_se_sodrzi_produktot,

            (select count(n2) from project.naracka as n2\040
            join project.naracka_sodrzi_produkt nsp2 on n2.id_naracka = nsp2.id_naracka\s
            where nsp2.id_produkt = p.id_produkt and n2.adresa like '/'\s
            and n2.datum between now() - interval '3months' and now())
            as broj_na_naracki_na_produktot_koi_korisnikot_sam_ke_gi_podigne,

            (select sum(nsp2.kolicina) from project.naracka as n2\s
            join project.naracka_sodrzi_produkt nsp2 on n2.id_naracka = nsp2.id_naracka\s
            where nsp2.id_produkt = p.id_produkt and n2.adresa like '/'\s
            and n2.datum between now() - interval '3months' and now())\s
            as  kolicina_prodadena_na_produktot_bez_dostava,

            (select count(n3) from project.naracka as n3\s
            join project.naracka_sodrzi_produkt nsp3 on n3.id_naracka = nsp3.id_naracka\s
            where nsp3.id_produkt = p.id_produkt and n3.adresa not like '/' and n3.datum between now() - interval '3months' and now())
            as broj_na_naracki_na_produktot_koi_ke_bidat_dostaveni_na_korisnikot,

            (select sum(nsp3.kolicina) from project.naracka as n3\s
            join project.naracka_sodrzi_produkt nsp3 on n3.id_naracka = nsp3.id_naracka
            where nsp3.id_produkt = p.id_produkt and n3.adresa not like '/' and n3.datum between now() - interval '3months' and now())
            as kolicina_prodadena_na_produktot_preku_dostava

            from project.produkt as p
            join project.naracka_sodrzi_produkt as nsp on p.id_produkt = nsp.id_produkt\s
            join project.naracka as n on nsp.id_naracka = n.id_naracka\s
            where n.datum between now() - interval '3months' and now()
            group by p.ime,p.id_produkt;""",
    nativeQuery = true)
    List<Object> statistics1();

}
