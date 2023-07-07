package project.fmo.app.projcetfmo.Service.impl;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import project.fmo.app.projcetfmo.Model.ProduktEOdKategorija;
import project.fmo.app.projcetfmo.Model.ProduktEOdKategorijaPK;
import project.fmo.app.projcetfmo.Repository.ProduktEOdKategorijaRepository;
import project.fmo.app.projcetfmo.Service.ProduktEOdKategorijaService;
import project.fmo.app.projcetfmo.Service.ProduktService;

import java.util.List;

@Service
public class ProduktEOdKategorijaServiceImpl implements ProduktEOdKategorijaService {

    private final ProduktEOdKategorijaRepository produktEOdKategorijaRepository;

    public ProduktEOdKategorijaServiceImpl(ProduktEOdKategorijaRepository produktEOdKategorijaRepository) {
        this.produktEOdKategorijaRepository = produktEOdKategorijaRepository;
    }

    @Override
    public ProduktEOdKategorija save(int idProdukt, int idKategorija) {
        ProduktEOdKategorija produktEOdKategorija= new ProduktEOdKategorija(new ProduktEOdKategorijaPK(idProdukt, idKategorija));
        produktEOdKategorijaRepository.save(produktEOdKategorija);
        return produktEOdKategorija;
    }

    @Transactional
    @Override
    public ProduktEOdKategorija edit(int idProdukt, int idKategorija) {
//        ProduktEOdKategorijaPK pk = new ProduktEOdKategorijaPK(idProdukt,idKategorija);
        ProduktEOdKategorija peodkD = produktEOdKategorijaRepository.findByIdProdukt(idProdukt);
        produktEOdKategorijaRepository.deleteByIdProdukt(peodkD.getIdProdukt());
        ProduktEOdKategorijaPK pk = new ProduktEOdKategorijaPK(idProdukt, idKategorija);
        ProduktEOdKategorija peodk = new ProduktEOdKategorija(pk);
       produktEOdKategorijaRepository.save(peodk);

        return peodk;
    }

    @Override
    public List<ProduktEOdKategorija> findAll() {
        return produktEOdKategorijaRepository.findAll();
    }

    @Override
    public ProduktEOdKategorija findByIdProdukt(int idProdukt) {
        return produktEOdKategorijaRepository.findByIdProdukt(idProdukt);
    }

    @Transactional
    @Override
    public void deleteByIdProdukt(int idProdukt) {

        this.produktEOdKategorijaRepository.deleteByIdProdukt(idProdukt);
    }

    @Override
    public ProduktEOdKategorija findByIdProduktAndIdKategorija(int idProdukt, int idKategorija) {
        return produktEOdKategorijaRepository.findByIdProduktAndIdKategorija(idProdukt,idKategorija);
    }
}
