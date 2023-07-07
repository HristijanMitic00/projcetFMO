package project.fmo.app.projcetfmo.Service.impl;

import org.springframework.stereotype.Service;
import project.fmo.app.projcetfmo.Model.Dostava;
import project.fmo.app.projcetfmo.Model.Dostavuvac;
import project.fmo.app.projcetfmo.Repository.DostavaRepository;
import project.fmo.app.projcetfmo.Service.DostavaService;

import java.util.List;

@Service
public class DostavaServiceImpl implements DostavaService {

    private final DostavaRepository dostavaRepository;

    public DostavaServiceImpl(DostavaRepository dostavaRepository) {
        this.dostavaRepository = dostavaRepository;
    }

    @Override
    public List<Dostava> findByIdKorisnikAndStatus(Dostavuvac dostavuvac, String status) {
        return dostavaRepository.findByDostavuvacAndStatus(dostavuvac,status);
    }

    @Override
    public Dostava edit(Integer id) {
        Dostava d = dostavaRepository.findById(id).orElse(null);
        assert d != null;
        d.setStatus("dostavena");
        dostavaRepository.save(d);
        return d;
    }
}
