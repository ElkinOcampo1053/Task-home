package co.edu.utp.misiontic.g12g4.backend.taskhome.service;

import java.util.List;

//import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dao.IUsuariosDao;
import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.Usuarios;

public interface UsuariosService {

    public List<Usuarios> ListarUsuarios();
     
    public void guardar(Usuarios usuarios);

    public void guardarAdmin(Usuarios usuarios);

    public void eliminar(Usuarios usuarios);

    public Usuarios encontrarUsuarios(Usuarios usuarios);  

}
