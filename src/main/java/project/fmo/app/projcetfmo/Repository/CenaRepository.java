package project.fmo.app.projcetfmo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.fmo.app.projcetfmo.Model.Cena;
import project.fmo.app.projcetfmo.Model.CenaPK;

public interface CenaRepository extends JpaRepository<Cena, CenaPK> {
    Cena findByIdProdukt(Integer idProdukt);
    void deleteByIdProdukt(Integer idProdukt);
}
