package co.edu.utp.misiontic.g12g4.backend.taskhome.service;

import java.util.List;

import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dao.IGrupoFamiliarDao;
import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.GrupoFamiliar;

public interface GrupoFamiliarService {
    public List<GrupoFamiliar> ListarGrupoFamiliar();

    public void guardar(GrupoFamiliar grupoFamiliar);

    public void eliminar(GrupoFamiliar grupoFamiliar);

    public GrupoFamiliar encontrarRegistroTarea(GrupoFamiliar grupoFamiliar);
}
