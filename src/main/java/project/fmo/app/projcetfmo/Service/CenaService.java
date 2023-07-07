package project.fmo.app.projcetfmo.Service;

import project.fmo.app.projcetfmo.Model.Cena;

import java.util.Date;
import java.util.List;

public interface CenaService {


    Cena save(Integer idProdukt, java.sql.Date cenaOd, java.sql.Date cenaDo, int iznos);
    Cena edit (Integer idProdukt, java.sql.Date cenaOd, java.sql.Date cenaDo, int iznos);

    List<Cena> findAll();

    Cena findByIdProdukt(int idProdukt);
    void deleteByIdProdukt(int idProdukt);


}
