package co.edu.utp.misiontic.g12g4.backend.taskhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

// Spring MVC

@AllArgsConstructor
@Controller
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

    @GetMapping("/password")
    public String goToPassword(Model model) {
        return "password";
    }
}
