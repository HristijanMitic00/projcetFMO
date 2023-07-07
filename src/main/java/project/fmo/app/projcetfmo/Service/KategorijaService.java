package project.fmo.app.projcetfmo.Service;

import project.fmo.app.projcetfmo.Model.Kategorija;

import java.util.List;

public interface KategorijaService {


    List<Kategorija> findAll();
    Kategorija save(String ime);
    Kategorija edit(Integer id, String ime);

}
