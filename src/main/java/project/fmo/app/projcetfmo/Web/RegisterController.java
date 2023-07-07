package project.fmo.app.projcetfmo.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.fmo.app.projcetfmo.Service.KorisnikService;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final KorisnikService korisnikService;


    public RegisterController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }


    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("bodyContent","register");
        return "master_template";
    }

    @PostMapping
    public String register(@RequestParam String name_surname,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String mail,
                           @RequestParam String number) {
        try{
            if(korisnikService.findbyImePrezime(name_surname) != null) throw  new RuntimeException();
            this.korisnikService.register(name_surname, password, repeatedPassword, mail, number);
            return "redirect:/home";
        } catch (RuntimeException r) {
            return "redirect:/register?error=InvalidRegistration";
        }
    }



}
