package project.fmo.app.projcetfmo.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.fmo.app.projcetfmo.Model.*;
import project.fmo.app.projcetfmo.Service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/order")
public class NarackaController {

    private final NarackaService narackaService;
    private final NarackaSodrziProduktService narackaSodrziProduktService;
    private final KorisnikService korisnikService;
    private final KupuvacService kupuvacService;
    private final CenaService cenaService;

    private final ProduktService produktService;

    public NarackaController(NarackaService narackaService, NarackaSodrziProduktService narackaSodrziProduktService, KorisnikService korisnikService, KupuvacService kupuvacService, CenaService cenaService, ProduktService produktService) {
        this.narackaService = narackaService;
        this.narackaSodrziProduktService = narackaSodrziProduktService;
        this.korisnikService = korisnikService;
        this.kupuvacService = kupuvacService;
        this.cenaService = cenaService;
        this.produktService = produktService;
    }

    @GetMapping
    public String getShoppingCartPage(@RequestParam(required = false) String error,
                                      HttpServletRequest req,
                                      Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        String username = req.getRemoteUser();
        Korisnik korisnik = korisnikService.findbyImePrezime(username);
        Kupuvac kupuvac = kupuvacService.findById(korisnik.getIdKorisnik());
        Naracka naracka = this.narackaService.findByIdKorisniktAndStatus(kupuvac.getIdKorisnik(),"aktivna");
        if(naracka == null){
            model.addAttribute("bodyContent", "home");
            return "master_template";
        }
        List<NarackaSodrziProdukt> narackaSodrziProdukt = narackaSodrziProduktService.findByIdNaracka(naracka.getIdNaracka());
        List<Produkt> produktList =  produktService.findAll();
        model.addAttribute("order", naracka);
        model.addAttribute("products", produktList);
        model.addAttribute("po", narackaSodrziProdukt);
        model.addAttribute("prices", cenaService.findAll());
        model.addAttribute("bodyContent", "cart");
        return "master_template";
    }

    @PostMapping("/{id}/success")
    public String processOrder(@PathVariable Integer id,HttpServletRequest req,@RequestParam(required = false) String address){
        Naracka n = narackaService.findByIdNaracka(id);
        String username = req.getRemoteUser();
        Korisnik korisnik = korisnikService.findbyImePrezime(username);
        Kupuvac kupuvac = kupuvacService.findById(korisnik.getIdKorisnik());
        if(address!=null) {
            narackaService.edit(0, "se sprema", address, kupuvac.getIdKorisnik(), n.getIdNaracka());
        }
        else {
            narackaService.edit(0, "se sprema", "/", kupuvac.getIdKorisnik(), n.getIdNaracka());
        }
        return "redirect:/products";
    }



}
