package co.edu.utp.misiontic.g12g4.backend.taskhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.RegistroTareas;
import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.Usuarios;
import co.edu.utp.misiontic.g12g4.backend.taskhome.service.RegistroTareasService;

import co.edu.utp.misiontic.g12g4.backend.taskhome.service.UsuariosService;
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
    
    @Autowired
    private UsuariosService usuariosService;
   
    @GetMapping("/principal")
    public String principal(Model model){
        var registroTareas = registroTareasService.ListarRegistroTareas();
        //log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("RegistroTareas", registroTareas);

        var usuarios = usuariosService.ListarUsuarios();
        //log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("Usuarios", usuarios);

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
    //////////////////////////////////////////////////////////////////////////////////////
    /*Datos de los Usuarios*/
    //////////////////////////////////////////////////////////////////////////////////////
    /*Path de Agregar*/
    @GetMapping("/agregarUsuario")
    public String agregar(Usuarios usuarios){
        return "modificarUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardar(Usuarios usuarios){
        usuariosService.guardar(usuarios);
        return "redirect:/principal";
    }

    @GetMapping("/modificarUsuario/{id}")
    public String editar(Usuarios usuarios, Model model){
        usuarios = usuariosService.encontrarUsuarios(usuarios);
        model.addAttribute("usuarios", usuarios);
        return "modificarUsuario";
    }

    @GetMapping("/eliminarUsuario/{id}")
    public String eliminar(Usuarios usuarios){
        usuariosService.eliminar(usuarios);
        return "redirect:/principal";
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// Crear Usuario Admin
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/agregarUsuarioAdmin")
    public String agregarAdmin(Usuarios usuarios){
        return "registro";
    }

    @PostMapping("/guardarUsuarioAdmin")
    public String guardarAdmin(Usuarios usuarios){
        usuariosService.guardar(usuarios);
        return "redirect:/login";
    }
    ////////////////////////////////////////////////////////////////////////////////////////
}
