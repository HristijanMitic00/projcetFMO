package project.fmo.app.projcetfmo.Service.impl;

import org.springframework.stereotype.Service;
import project.fmo.app.projcetfmo.Model.Kupuvac;
import project.fmo.app.projcetfmo.Model.Naracka;
import project.fmo.app.projcetfmo.Model.Produkt;
import project.fmo.app.projcetfmo.Repository.KupuvacRepository;
import project.fmo.app.projcetfmo.Repository.NarackaRepository;
import project.fmo.app.projcetfmo.Service.NarackaService;

import java.sql.Date;
import java.util.List;

@Service
public class NarackaServiceImpl implements NarackaService {

    private final NarackaRepository narackaRepository;
    private final KupuvacRepository kupuvacRepository;

    public NarackaServiceImpl(NarackaRepository narackaRepository, KupuvacRepository kupuvacRepository) {
        this.narackaRepository = narackaRepository;
        this.kupuvacRepository = kupuvacRepository;
    }

    @Override
    public List<Produkt> allProductsInOrder(Integer narackaId) {
        return null;
    }

    @Override
    public Naracka getActiveOrder(String username) {
        return null;
    }

    @Override
    public Naracka findByIdKorisniktAndStatus(Integer id, String s) {
        Kupuvac k = kupuvacRepository.findById(id).orElse(null);
        return narackaRepository.findByKupuvacAndStatus(k,s);
    }

    @Override
    public Naracka save(int vkupnoSuma, Date date, String status, String adresa, Kupuvac k) {
        return narackaRepository.save(new Naracka(vkupnoSuma,date,status,adresa,k));
    }

    @Override
    public Naracka edit(int vkupnoSuma, String status, String adresa, Integer idK, Integer idN) {
        Kupuvac k = kupuvacRepository.findById(idK).orElse(null);
        Naracka n = narackaRepository.findByKupuvacAndIdNaracka(k,idN);
        n.setVkupnoSuma(n.getVkupnoSuma()+vkupnoSuma);
        n.setStatus(status);
        n.setAdresa(adresa);
        narackaRepository.save(n);
        return n;
    }

    @Override
    public Naracka findByKupuvac(Kupuvac k) {
        return narackaRepository.findByKupuvac(k);
    }

    @Override
    public Naracka findByIdNaracka(Integer id) {
        return narackaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Naracka> findAll() {
        return narackaRepository.findAll();
    }
}
