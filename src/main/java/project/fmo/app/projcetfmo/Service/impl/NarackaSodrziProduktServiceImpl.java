package project.fmo.app.projcetfmo.Service.impl;

import org.springframework.stereotype.Service;
import project.fmo.app.projcetfmo.Model.NarackaSodrziProdukt;
import project.fmo.app.projcetfmo.Repository.NarackaSodrziProduktRepository;
import project.fmo.app.projcetfmo.Service.NarackaSodrziProduktService;

import java.util.List;

@Service
public class NarackaSodrziProduktServiceImpl implements NarackaSodrziProduktService {

   private final NarackaSodrziProduktRepository narackaSodrziProduktRepository;

    public NarackaSodrziProduktServiceImpl(NarackaSodrziProduktRepository narackaSodrziProduktRepository) {
        this.narackaSodrziProduktRepository = narackaSodrziProduktRepository;
    }

    @Override
    public NarackaSodrziProdukt findByIdProduktAndIdNaracka(Integer idP, Integer idN) {
        return narackaSodrziProduktRepository.findByIdProduktAndIdNaracka(idP,idN);
    }

    @Override
    public NarackaSodrziProdukt edit(Integer idP, Integer idN, Integer quantity, Integer price) {
        NarackaSodrziProdukt n = narackaSodrziProduktRepository.findByIdProduktAndIdNaracka(idP,idN);
        n.setCena(price);
        n.setKolicina(n.getKolicina()+quantity);
        narackaSodrziProduktRepository.save(n);
        return n;
    }

    @Override
    public NarackaSodrziProdukt save(Integer idP, Integer idN, Integer quantity, Integer price) {
        NarackaSodrziProdukt n = new NarackaSodrziProdukt(idP,idN,quantity, price);
        narackaSodrziProduktRepository.save(n);
        return n;
    }

    @Override
    public List<NarackaSodrziProdukt> findByIdNaracka(Integer id) {
        return narackaSodrziProduktRepository.findByIdNaracka(id);
    }

    @Override
    public void deleteProduct(Integer id) {
        List<NarackaSodrziProdukt> narackaSodrziProdukts = narackaSodrziProduktRepository.findByIdProdukt(id);
        narackaSodrziProduktRepository.deleteByIdProdukt(id);
    }

    @Override
    public List<NarackaSodrziProdukt> findAll() {
        return narackaSodrziProduktRepository.findAll();
    }

    @Override
    public List<NarackaSodrziProdukt> findByIdProdukt(Integer id) {
        return narackaSodrziProduktRepository.findByIdProdukt(id);
    }


}
