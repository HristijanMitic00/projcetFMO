package project.fmo.app.projcetfmo.Service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.fmo.app.projcetfmo.Model.AdminKorisnik;
import project.fmo.app.projcetfmo.Model.Produkt;
import project.fmo.app.projcetfmo.Repository.AdminRepository;
import project.fmo.app.projcetfmo.Repository.ProduktRepository;
import project.fmo.app.projcetfmo.Service.ProduktService;


import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ProduktServiceImpl implements ProduktService {

    private final ProduktRepository produktRepository;
    private final AdminRepository adminRepository;

    public ProduktServiceImpl(ProduktRepository produktRepository, AdminRepository adminRepository) {
        this.produktRepository = produktRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public Optional<Produkt> findById(Integer id) {
        return produktRepository.findById(id);
    }

    @Override
    public List<Produkt> findAll() {
        return produktRepository.findAll();
    }

    @Override
    public Produkt save(String ime, String opis) {
        List<AdminKorisnik> list = adminRepository.findAll();
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        AdminKorisnik a = list.get(randomIndex);
        if (a == null){
            throw new RuntimeException();
        }
        Produkt p = new Produkt(ime, opis, a);
        produktRepository.save(p);
        return p;
    }

    @Override
    public Produkt edit(Integer id, String ime, String opis) {
        Produkt p = produktRepository.findById(id).orElse(null);
        if (p == null ){
            throw new RuntimeException();
        }
        p.setIme(ime);
        p.setOpis(opis);
        produktRepository.save(p);
        return p;
    }

    @Override
    public void deleteById(Integer id) {
        produktRepository.deleteById(id);
    }

    @Override
    public List<Object> statistics1() {
        return produktRepository.statistics1();
    }
}
