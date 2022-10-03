package co.edu.utp.misiontic.g12g4.backend.taskhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


// Spring MVC

@AllArgsConstructor
@Controller
@Slf4j
public class TaskHomeController {

    @GetMapping(value = { "/", "/index", "/index.html" })
    public String goToIndex(Model model) {
        //model.addAttribute("page", "home");
        return "index";
    }
    
    @GetMapping("/login")
    public String goToLogin(Model model) {
        return "login";
    }

    @GetMapping("/principal")
    public String goToPrincipal(Model model) {
        return "principal";
    }

    @GetMapping("/registro")
    public String goToRegistro(Model model) {
        return "registro";
    }
}
