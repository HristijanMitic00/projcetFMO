package project.fmo.app.projcetfmo.Service;

import project.fmo.app.projcetfmo.Model.NarackaSodrziProdukt;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface NarackaSodrziProduktService {
    NarackaSodrziProdukt findByIdProduktAndIdNaracka(Integer idP, Integer idN);
    NarackaSodrziProdukt edit(Integer idP, Integer idN, Integer quantity, Integer price);
    NarackaSodrziProdukt save(Integer idP, Integer idN, Integer quantity, Integer price);
    List<NarackaSodrziProdukt> findByIdNaracka(Integer id);
    void deleteProduct(Integer id);

    List<NarackaSodrziProdukt> findAll();

    List<NarackaSodrziProdukt> findByIdProdukt(Integer id);
}
