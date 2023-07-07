package project.fmo.app.projcetfmo.Service;

import org.springframework.data.domain.Page;
import project.fmo.app.projcetfmo.Model.Produkt;

import java.util.List;
import java.util.Optional;

public interface ProduktService {

    Optional<Produkt> findById(Integer id);
    List<Produkt> findAll();
    Produkt save(String ime, String opis);
    Produkt edit(Integer id,String ime, String opis);
    void deleteById(Integer id);

    List<Object> statistics1();

}
