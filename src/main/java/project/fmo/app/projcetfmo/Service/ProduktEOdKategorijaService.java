package project.fmo.app.projcetfmo.Service;

import project.fmo.app.projcetfmo.Model.ProduktEOdKategorija;

import java.util.List;

public interface ProduktEOdKategorijaService {


    ProduktEOdKategorija save(int idProdukt, int idKategorija);
    ProduktEOdKategorija edit(int idProdukt, int idKategorija);

    List<ProduktEOdKategorija> findAll();

    ProduktEOdKategorija findByIdProdukt(int idProdukt);
    void deleteByIdProdukt(int idProdukt);

    ProduktEOdKategorija findByIdProduktAndIdKategorija(int idProdukt, int idKategorija);

}
