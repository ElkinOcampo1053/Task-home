package co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dao;

import org.springframework.data.repository.CrudRepository;
import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.Usuarios;

public interface IUsuariosDao extends CrudRepository<Usuarios, Long>{
    
}
