package guru.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SfgPetClinicApplicationController {

    @RequestMapping( {"", "/", "index", "index.html"})
    public String index(){
        return "index";
    }
}
