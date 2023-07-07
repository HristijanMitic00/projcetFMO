package project.fmo.app.projcetfmo.Service.impl;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import project.fmo.app.projcetfmo.Model.Cena;
import project.fmo.app.projcetfmo.Model.CenaPK;
import project.fmo.app.projcetfmo.Repository.CenaRepository;
import project.fmo.app.projcetfmo.Service.CenaService;

import java.sql.Date;
import java.util.List;

@Service
public class CenaServiceImpl implements CenaService {

    private final CenaRepository cenaRepository;

    public CenaServiceImpl(CenaRepository cenaRepository) {
        this.cenaRepository = cenaRepository;
    }

    @Override
    public Cena save(Integer idProdukt, java.sql.Date cenaOd, java.sql.Date cenaDo, int iznos) {
            Cena c = new Cena(idProdukt,cenaOd,cenaDo,iznos);
            cenaRepository.save(c);
        return c;
    }

    @Transactional
    @Override
    public Cena edit(Integer idProdukt, Date cenaOd, Date cenaDo, int iznos) {
        Cena c = cenaRepository.findByIdProdukt(idProdukt);
        cenaRepository.deleteByIdProdukt(c.getIdProdukt());
        Cena c1 = new Cena(idProdukt,cenaOd,cenaDo,iznos);
        cenaRepository.save(c1);
        return c;
    }

    @Override
    public List<Cena> findAll() {
        return cenaRepository.findAll();
    }

    @Override
    public Cena findByIdProdukt(int idProdukt) {
        return cenaRepository.findByIdProdukt(idProdukt);
    }

    @Transactional
    @Override
    public void deleteByIdProdukt(int idProdukt) {
        cenaRepository.deleteByIdProdukt(idProdukt);
    }
}
