package project.fmo.app.projcetfmo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.fmo.app.projcetfmo.Model.Dostava;
import project.fmo.app.projcetfmo.Model.Dostavuvac;

import java.util.List;

public interface DostavaRepository extends JpaRepository<Dostava, Integer> {
    List<Dostava> findByDostavuvacAndStatus(Dostavuvac dostavuvac, String status);
    List<Dostava> findByStatus(String status);
}
