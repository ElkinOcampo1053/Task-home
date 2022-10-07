package co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import org.springframework.data.repository.CrudRepository;
import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.Usuarios;

public interface IUsuariosDao extends JpaRepository<Usuarios, Long>{
/*
    @Query(nativeQuery = false,value = " SELECT * FROM usuarios WHERE id_grupo_familiar = 1")
    Usuarios rearIdGrupo(Integer id);*/
}
