package project.fmo.app.projcetfmo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.fmo.app.projcetfmo.Model.Kupuvac;
import project.fmo.app.projcetfmo.Model.Naracka;

public interface NarackaRepository extends JpaRepository<Naracka, Integer> {
    Naracka findByKupuvacAndStatus(Kupuvac kupuvac, String status);
    Naracka findByKupuvacAndIdNaracka(Kupuvac kupuvac, Integer idN);
    Naracka findByKupuvac(Kupuvac k);

}
