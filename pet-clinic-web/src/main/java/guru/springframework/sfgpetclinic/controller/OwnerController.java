package guru.springframework.sfgpetclinic.controller;

import guru.springframework.sfgpetclinic.service.map.OwnerServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {
  private final OwnerServiceMap ownerServiceMap;

  public OwnerController(OwnerServiceMap ownerServiceMap) {
    this.ownerServiceMap = ownerServiceMap;
  }

  @RequestMapping({"/owner", "/owner/index", "/owner/index.html"})
    public String getIndex(Model model){
      model.addAttribute("owners", ownerServiceMap.findAll());
    return "owner/index";
  }
}
