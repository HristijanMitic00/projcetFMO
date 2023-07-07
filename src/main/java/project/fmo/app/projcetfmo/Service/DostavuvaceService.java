package project.fmo.app.projcetfmo.Service;

import project.fmo.app.projcetfmo.Model.Dostavuvac;

import javax.persistence.criteria.CriteriaBuilder;

public interface DostavuvaceService {

    Dostavuvac findById(Integer id);
}
