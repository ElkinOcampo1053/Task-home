package co.edu.utp.misiontic.g12g4.backend.taskhome.service;

import java.util.List;

import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dao.IRegistroTareasDao;
import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.RegistroTareas;

public interface RegistroTareasService {

    public List<RegistroTareas> ListarRegistroTareas();

    public void guardar(RegistroTareas registroTareas);

    public void eliminar(RegistroTareas registroTareas);

    public RegistroTareas encontrarRegistroTarea(RegistroTareas registroTareas);

}
