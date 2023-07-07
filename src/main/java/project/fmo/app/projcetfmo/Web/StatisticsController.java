package project.fmo.app.projcetfmo.Web;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.fmo.app.projcetfmo.Model.Korisnik;
import project.fmo.app.projcetfmo.Model.Produkt;
import project.fmo.app.projcetfmo.Service.KorisnikService;
import project.fmo.app.projcetfmo.Service.ProduktService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    private final ProduktService produktService;
    private final KorisnikService korisnikService;

    public StatisticsController(ProduktService produktService, KorisnikService korisnikService) {
        this.produktService = produktService;
        this.korisnikService = korisnikService;
    }

    @GetMapping
    public String getStatistics(Model model){
        List<Object> korisnikList = korisnikService.statistics2();
        List<String> ime = new ArrayList<>();
        List<String> id = new ArrayList<>();
        List<Integer> vkupno_naracki = new ArrayList<>();
        List<Float> prosecna_suma_na_naracka_za_site_kupuvaci = new ArrayList<>();
        List<Integer> vkupno_suma_od_site_naracki_na_kupuvacot = new ArrayList<>();
        List<Integer> vkupno_naracki_nad_prosek_na_korisnikot = new ArrayList<>();
        List<Integer> vkupno_suma_na_naracki_nad_prosek_za_korisnikot = new ArrayList<>();
//        for(int i =0 ; i< korisnikList.size();i++) {
//            ime.add(korisnikList.get(i)[0].toString());
//        }
        List<Object> produktList = produktService.statistics1();
        model.addAttribute("products", produktList);
        model.addAttribute("users", korisnikList);
        model.addAttribute("bodyContent", "statistics");
        return "master_template";

    }
}
