package project.fmo.app.projcetfmo.Service.impl;

import org.springframework.stereotype.Service;
import project.fmo.app.projcetfmo.Model.Dostavuvac;
import project.fmo.app.projcetfmo.Repository.DostavuvacRepository;
import project.fmo.app.projcetfmo.Service.DostavuvaceService;

@Service
public class DostavuvacServiceImpl implements DostavuvaceService {

    private final DostavuvacRepository dostavuvacRepository;

    public DostavuvacServiceImpl(DostavuvacRepository dostavuvacRepository) {
        this.dostavuvacRepository = dostavuvacRepository;
    }

    @Override
    public Dostavuvac findById(Integer id) {
        return dostavuvacRepository.findById(id).orElse(null);
    }
}
