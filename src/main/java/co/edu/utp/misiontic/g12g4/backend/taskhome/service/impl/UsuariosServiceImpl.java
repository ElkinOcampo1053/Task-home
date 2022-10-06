package co.edu.utp.misiontic.g12g4.backend.taskhome.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dao.IUsuariosDao;
import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.Usuarios;
import co.edu.utp.misiontic.g12g4.backend.taskhome.service.UsuariosService;

@Service  
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired
    private IUsuariosDao iUsuariosDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> ListarUsuarios() {
        return (List<Usuarios>) iUsuariosDao.findAll();
    }
    
    @Override
    @Transactional
    public void guardar(Usuarios usuarios) {
        iUsuariosDao.save(usuarios);
    }
    
    @Override
    @Transactional
    public void guardarAdmin(Usuarios usuarios) {
        iUsuariosDao.save(usuarios);
    }

    @Override
    public void eliminar(Usuarios usuarios) {
        iUsuariosDao.delete(usuarios);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios encontrarUsuarios(Usuarios usuarios) {
        return iUsuariosDao.findById(usuarios.getId()).orElse(null);
    }
}
