package project.fmo.app.projcetfmo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.fmo.app.projcetfmo.Model.Kategorija;

public interface KategorijaRepository extends JpaRepository<Kategorija, Integer> {
}
