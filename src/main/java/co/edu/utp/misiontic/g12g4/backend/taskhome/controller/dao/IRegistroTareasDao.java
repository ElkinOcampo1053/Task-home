package co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dao;

import org.springframework.data.repository.CrudRepository;

import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.RegistroTareas;

public interface IRegistroTareasDao extends CrudRepository<RegistroTareas, Long>{
    
}
