package co.edu.utp.misiontic.g12g4.backend.taskhome.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dao.IRegistroTareasDao;
import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.RegistroTareas;
import co.edu.utp.misiontic.g12g4.backend.taskhome.service.RegistroTareasService;

@Service    
public class RegistroTareasServiceImpl implements RegistroTareasService{

    @Autowired
    private IRegistroTareasDao iRegistroTareasDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<RegistroTareas> ListarRegistroTareas() {
        return (List<RegistroTareas>) iRegistroTareasDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(RegistroTareas registroTareas) {
        iRegistroTareasDao.save(registroTareas);
    }

    @Override
    public void eliminar(RegistroTareas registroTareas) {
        iRegistroTareasDao.delete(registroTareas);
    }

    @Override
    @Transactional(readOnly = true)
    public RegistroTareas encontrarRegistroTarea(RegistroTareas registroTareas) {
        return iRegistroTareasDao.findById(registroTareas.getId()).orElse(null);
    }
    
}
