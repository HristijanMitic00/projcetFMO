package project.fmo.app.projcetfmo.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.fmo.app.projcetfmo.Model.Dostava;
import project.fmo.app.projcetfmo.Model.Dostavuvac;
import project.fmo.app.projcetfmo.Model.Korisnik;
import project.fmo.app.projcetfmo.Service.DostavaService;
import project.fmo.app.projcetfmo.Service.DostavuvaceService;
import project.fmo.app.projcetfmo.Service.KorisnikService;
import project.fmo.app.projcetfmo.Service.NarackaService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/delivery")
public class DostavaController {

    private final DostavaService dostavaService;
    private final DostavuvaceService dostavuvaceService;
    private final KorisnikService korisnikService;
    private final NarackaService narackaService;

    public DostavaController(DostavaService dostavaService, DostavuvaceService dostavuvaceService, KorisnikService korisnikService, NarackaService narackaService) {
        this.dostavaService = dostavaService;
        this.dostavuvaceService = dostavuvaceService;
        this.korisnikService = korisnikService;
        this.narackaService = narackaService;
    }


    @GetMapping
    public String getDelivery(Model model, HttpServletRequest req){
        String username = req.getRemoteUser();
        Korisnik korisnik = korisnikService.findbyImePrezime(username);
        Dostavuvac dostavuvac = dostavuvaceService.findById(korisnik.getIdKorisnik());
        List<Dostava> dostavaList = dostavaService.findByIdKorisnikAndStatus(dostavuvac, "za dostava");
        model.addAttribute("user", korisnik);
        model.addAttribute("orders", narackaService.findAll());
        model.addAttribute("delivers", dostavaList);
        model.addAttribute("bodyContent", "delivery");
        return "master_template";
    }

    @PostMapping("/{id}")
    public String OrderDelivered(@PathVariable Integer id){
        dostavaService.edit(id);
        return  "redirect:/delivery";
    }

}
