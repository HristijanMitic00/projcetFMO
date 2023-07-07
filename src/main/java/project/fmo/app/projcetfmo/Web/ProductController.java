package project.fmo.app.projcetfmo.Web;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.fmo.app.projcetfmo.Model.*;
import project.fmo.app.projcetfmo.Service.*;


import java.sql.Date;
import java.text.ParseException;

import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProduktService produktService;
    private final KategorijaService kategorijaService;
    private final ProduktEOdKategorijaService produktEOdKategorijaService;
    private final CenaService cenaService;
    private final NarackaService narackaService;
    private final NarackaSodrziProduktService narackaSodrziProduktService;
    private final KupuvacService kupuvacService;
    private final KorisnikService korisnikService;

    public ProductController(ProduktService produktService, KategorijaService kategorijaService, ProduktEOdKategorijaService produktEOdKategorijaService, CenaService cenaService, NarackaService narackaService, NarackaSodrziProduktService narackaSodrziProduktService, KupuvacService kupuvacService, KorisnikService korisnikService) {
        this.produktService = produktService;
        this.kategorijaService = kategorijaService;
        this.produktEOdKategorijaService = produktEOdKategorijaService;
        this.cenaService = cenaService;
        this.narackaService = narackaService;
        this.narackaSodrziProduktService = narackaSodrziProduktService;
        this.kupuvacService = kupuvacService;
        this.korisnikService = korisnikService;
    }

    @GetMapping
    public String getProductPage(Model model) {
        List<Produkt> products = this.produktService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("kat", kategorijaService.findAll());
        model.addAttribute("categories", produktEOdKategorijaService.findAll());
        model.addAttribute("prices", cenaService.findAll());
        model.addAttribute("bodyContent", "products");
        return "master_template";
    }

    @GetMapping("/{id}")
    public String getProductInfo(Model model, @PathVariable Integer id){
        Produkt p = produktService.findById(id).orElse(null);
        Cena c = cenaService.findByIdProdukt(id);
        ProduktEOdKategorija pk = produktEOdKategorijaService.findByIdProdukt(id);
        List<Kategorija> k = kategorijaService.findAll();
        Kategorija kat = null;
        for ( Kategorija kategorija : k){
            if (kategorija.getIdKategorija() == pk.getIdKategorija()){
                kat=kategorija;
            }
        }
        model.addAttribute("product", p);
        model.addAttribute("price", c);
        model.addAttribute("category",pk);
        if(kat != null) {
            model.addAttribute("kat", kat);
        }
        model.addAttribute("bodyContent", "product_info");
        return "master_template";
    }

    @PostMapping("{id}/add-to-cart")
    public String addProductToCart(@PathVariable Integer id,
                                   @RequestParam String idKorisnik,
                                   @RequestParam int cena,
                                   @RequestParam int quantity){
        Korisnik kOrisnik = korisnikService.findbyImePrezime(idKorisnik);
        Kupuvac k = kupuvacService.findById(kOrisnik.getIdKorisnik());
        Naracka n = narackaService.findByIdKorisniktAndStatus(k.getIdKorisnik(),"aktivna");
            if (n == null){
                //Naracka narackaNova = new Naracka(cena*quantity, Date.valueOf(LocalDate.now()), "aktivna", "/", k);
                Naracka narackaNova = narackaService.save(cena*quantity, Date.valueOf(LocalDate.now()), "aktivna", "/", k);
                NarackaSodrziProdukt nsp = new NarackaSodrziProdukt(id,narackaNova.getIdNaracka(),quantity,cena);
                narackaSodrziProduktService.save(id,narackaNova.getIdNaracka(),quantity,cena);

                return "redirect:/products";
            }
            else {
                narackaService.edit(cena*quantity,n.getStatus(),n.getAdresa(),k.getIdKorisnik(),n.getIdNaracka());
                NarackaSodrziProdukt narackaSodrziProdukt = narackaSodrziProduktService.findByIdProduktAndIdNaracka(id,n.getIdNaracka());
                if(narackaSodrziProdukt == null){
                    NarackaSodrziProdukt nova = new NarackaSodrziProdukt(id,n.getIdNaracka(),quantity,cena);
                    narackaSodrziProduktService.save(id,n.getIdNaracka(),quantity,cena);
                }
                else{
                    narackaSodrziProduktService.edit(id,n.getIdNaracka(),quantity,cena);
                }
                return "redirect:/products";
          }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id,Model model) {
        if(narackaSodrziProduktService.findByIdProdukt(id).size() != 0){
            model.addAttribute("bodyContent", "not_valid_delete");
            return "master_template";
        }
        this.cenaService.deleteByIdProdukt(id);
        this.produktEOdKategorijaService.deleteByIdProdukt(id);
        this.produktService.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Integer id, Model model) {
        if (this.produktService.findById(id).isPresent()) {
            Produkt product = this.produktService.findById(id).get();
            Cena c = cenaService.findByIdProdukt(product.getIdProdukt());
            ProduktEOdKategorija produktEOdKategorija = produktEOdKategorijaService.findByIdProdukt(product.getIdProdukt());
            model.addAttribute("chosen", produktEOdKategorija);
            model.addAttribute("price", c);
            List<Kategorija> categories = this.kategorijaService.findAll();
            model.addAttribute("categories", categories);
            model.addAttribute("product", product);
            model.addAttribute("bodyContent", "add_product");
            return "master_template";
        }
        return "redirect:/products";
    }

    @GetMapping("/add-form")
    public String addProductPage(Model model) {
        List<Kategorija> categories = this.kategorijaService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("bodyContent", "add_product");
        return "master_template";
    }

    @PostMapping("/add")
    public String saveProduct(
            @RequestParam(required = false) Integer id,
            @RequestParam String name,
            @RequestParam(required = false) String description,
            @RequestParam Integer category,
            @RequestParam Date date,
            @RequestParam(required = false)  String dateTo,
            @RequestParam int price) throws ParseException {
            if(dateTo.length() != 0) {
                Date d = Date.valueOf(dateTo);

                if (id != null) {
                    this.produktService.edit(id, name, description);
                    this.cenaService.edit(id, date, d, price);
                    this.produktEOdKategorijaService.edit(id, category);

                } else {
                    Produkt p = this.produktService.save(name, description);
                    this.cenaService.save(p.getIdProdukt(), date, d, price);
                    this.produktEOdKategorijaService.save(p.getIdProdukt(), category);
                }
            }
            else{
                if (id != null) {
                this.produktService.edit(id, name, description);
                this.cenaService.edit(id, date, null, price);
                this.produktEOdKategorijaService.edit(id, category);

            } else {
                Produkt p = this.produktService.save(name, description);
                this.cenaService.save(p.getIdProdukt(), date, null, price);
                this.produktEOdKategorijaService.save(p.getIdProdukt(), category);
            }

            }
        return "redirect:/products";
    }




}
