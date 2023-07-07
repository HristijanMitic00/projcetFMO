package project.fmo.app.projcetfmo.Service;

import project.fmo.app.projcetfmo.Model.Kupuvac;
import project.fmo.app.projcetfmo.Model.Naracka;
import project.fmo.app.projcetfmo.Model.Produkt;

import java.sql.Date;
import java.util.List;

public interface NarackaService {

    List<Produkt> allProductsInOrder(Integer narackaId);
    Naracka getActiveOrder(String username);
    Naracka findByIdKorisniktAndStatus(Integer id, String s);

    Naracka save(int vkupnoSuma, Date date, String status, String adresa, Kupuvac k);
    Naracka edit(int vkupnoSuma,String status,String adresa, Integer idK, Integer idN);
    Naracka findByKupuvac(Kupuvac k);
    Naracka findByIdNaracka(Integer id);
    List<Naracka> findAll();


}
