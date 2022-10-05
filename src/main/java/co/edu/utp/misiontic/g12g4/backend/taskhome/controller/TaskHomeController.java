package co.edu.utp.misiontic.g12g4.backend.taskhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.RegistroTareas;
import co.edu.utp.misiontic.g12g4.backend.taskhome.service.RegistroTareasService;
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
    private RegistroTareasService registroTareasService;

    @GetMapping("/principal")
    public String principal(Model model){
        var registroTareas = registroTareasService.ListarRegistroTareas();
        //log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("RegistroTareas", registroTareas);
        return "principal";
    }
    
    /*Path de Agregar*/
    @GetMapping("/agregarTarea")
    public String agregar(RegistroTareas registroTareas){
        return "modificarTareas";
    }

    @PostMapping("/guardarTarea")
    public String guardar(RegistroTareas registroTareas){
        registroTareasService.guardar(registroTareas);
        return "redirect:/principal";
    }

    @GetMapping("/modificarTarea/{id}")
    public String editar(RegistroTareas registroTareas, Model model){
        registroTareas =registroTareasService.encontrarRegistroTarea(registroTareas);
        model.addAttribute("registroTareas", registroTareas);
        return "modificarTareas";
    }

    @GetMapping("/eliminarTarea/{id}")
    public String eliminar(RegistroTareas registroTareas){
        registroTareasService.eliminar(registroTareas);
        return "redirect:/principal";
    }

}
