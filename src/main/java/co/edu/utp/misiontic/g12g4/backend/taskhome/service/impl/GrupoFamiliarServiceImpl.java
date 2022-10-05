package co.edu.utp.misiontic.g12g4.backend.taskhome.service.impl;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

//import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dao.IGrupoFamiliarDao;
//import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.GrupoFamiliar;
//import co.edu.utp.misiontic.g12g4.backend.taskhome.service.GrupoFamiliarService;

@Service   
public class GrupoFamiliarServiceImpl implements GrupoFamiliarDao {
    /*Falta crear en el constructor

    @Autowired
    private IGrupoFamiliarDao iGrupoFamiliarDao;
    /*
    @Override
    @Transactional(readOnly = true)
    public List<GrupoFamiliar> ListarGrupoFamiliar() {
        return (List<GrupoFamiliar>) iGrupoFamiliarDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(GrupoFamiliar grupoFamiliar) {
        iGrupoFamiliarDao.save(grupoFamiliar);
    }

    @Override
    public void eliminar(GrupoFamiliar grupoFamiliar) {
        iGrupoFamiliarDao.delete(grupoFamiliar);
    }

    @Override
    @Transactional(readOnly = true)
    public RegistroTareas encontrarGrupoFamiliar(GrupoFamiliar grupoFamiliar) {
        return iGrupoFamiliarDao.findById(grupoFamiliar.getId()).orElse(null);
    }*/
}
