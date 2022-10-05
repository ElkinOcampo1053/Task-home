package co.edu.utp.misiontic.g12g4.backend.taskhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dao.IRegistroTareasDao;
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

    /*@GetMapping("/principal")
    public String goToPrincipal(Model model) {
        return "principal";
    }*/

    @GetMapping("/registro")
    public String goToRegistro(Model model) {
        return "registro";
    }

    @GetMapping(value = {"/modificarinf" , "/password"})
    public String goToModificarInf(Model model) {
        return "modificarinf";
    }

    @Autowired
    private IRegistroTareasDao iRegistroTareasDao;
    @GetMapping("/principal")
    public String principal(Model model){
        var registroTareas = iRegistroTareasDao.findAll();
        //log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("RegistroTareas", registroTareas);
        return "principal";
    }
}
