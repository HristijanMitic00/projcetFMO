package project.fmo.app.projcetfmo.Service;

import project.fmo.app.projcetfmo.Model.Dostava;
import project.fmo.app.projcetfmo.Model.Dostavuvac;

import java.util.List;

public interface DostavaService {

    List<Dostava> findByIdKorisnikAndStatus(Dostavuvac dostavuvac, String status);
    Dostava edit(Integer id);


}
