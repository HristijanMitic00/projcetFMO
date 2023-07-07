package project.fmo.app.projcetfmo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.fmo.app.projcetfmo.Model.ProduktEOdKategorija;
import project.fmo.app.projcetfmo.Model.ProduktEOdKategorijaPK;

public interface ProduktEOdKategorijaRepository extends JpaRepository<ProduktEOdKategorija, ProduktEOdKategorijaPK> {
    ProduktEOdKategorija findByIdProdukt(Integer idProdukt);
    void deleteByIdProdukt(Integer idProdukt);
    ProduktEOdKategorija findByIdProduktAndIdKategorija(Integer idProdukt,Integer idKategorija);
}
