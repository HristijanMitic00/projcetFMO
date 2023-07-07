package project.fmo.app.projcetfmo.Service.impl;

import org.springframework.stereotype.Service;
import project.fmo.app.projcetfmo.Model.Kategorija;
import project.fmo.app.projcetfmo.Repository.KategorijaRepository;
import project.fmo.app.projcetfmo.Service.KategorijaService;

import java.util.List;

@Service
public class KategorijaServiceImpl implements KategorijaService {

    private final KategorijaRepository kategorijaRepository;

    public KategorijaServiceImpl(KategorijaRepository kategorijaRepository) {
        this.kategorijaRepository = kategorijaRepository;
    }

    @Override
    public List<Kategorija> findAll() {
        return kategorijaRepository.findAll();
    }

    @Override
    public Kategorija save(String ime) {
        Kategorija k = new Kategorija(ime);
        kategorijaRepository.save(k);
        return k;
    }

    @Override
    public Kategorija edit(Integer id, String ime) {
        Kategorija k = kategorijaRepository.findById(id).orElse(null);
        assert k != null;
        k.setIme(ime);
        kategorijaRepository.save(k);
        return k;
    }
}
