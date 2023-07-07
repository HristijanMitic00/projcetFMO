package project.fmo.app.projcetfmo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.fmo.app.projcetfmo.Model.NarackaSodrziProdukt;
import project.fmo.app.projcetfmo.Model.NarackaSodrziProduktPK;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface NarackaSodrziProduktRepository extends JpaRepository<NarackaSodrziProdukt, NarackaSodrziProduktPK> {
    NarackaSodrziProdukt findByIdProduktAndIdNaracka(Integer idP, Integer idN);
    List<NarackaSodrziProdukt> findByIdNaracka(Integer id);
    void deleteByIdProdukt(Integer id);
    List<NarackaSodrziProdukt> findByIdProdukt(Integer id);
}
