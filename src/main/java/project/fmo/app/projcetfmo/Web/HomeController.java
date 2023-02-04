package project.fmo.app.projcetfmo.Web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/","/home"})
public class StoreController {


    @GetMapping
    public String getHomePage(){
        return "home";
    }

}
