package project.fmo.app.projcetfmo.Repository;

import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.fmo.app.projcetfmo.Model.AdminKorisnik;

import java.util.Collection;

public interface AdminRepository extends JpaRepository<AdminKorisnik, Integer> {

}
