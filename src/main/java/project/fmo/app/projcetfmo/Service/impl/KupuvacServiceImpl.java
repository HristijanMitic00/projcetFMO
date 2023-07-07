package project.fmo.app.projcetfmo.Service.impl;

import org.springframework.stereotype.Service;
import project.fmo.app.projcetfmo.Model.Kupuvac;
import project.fmo.app.projcetfmo.Repository.KupuvacRepository;
import project.fmo.app.projcetfmo.Service.KupuvacService;

@Service
public class KupuvacServiceImpl implements KupuvacService {

    private final KupuvacRepository kupuvacRepository;

    public KupuvacServiceImpl(KupuvacRepository kupuvacRepository) {
        this.kupuvacRepository = kupuvacRepository;
    }

    @Override
    public Kupuvac findById(Integer id) {
        return kupuvacRepository.findById(id).orElse(null);
    }
}
