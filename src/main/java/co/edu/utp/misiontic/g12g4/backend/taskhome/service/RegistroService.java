package co.edu.utp.misiontic.g12g4.backend.taskhome.service;

import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dto.RegistroRequest;
import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dto.RegistroResponse;


public interface RegistroService {
    RegistroResponse validateRegistro(String email);

    RegistroResponse getUserByEmail(String email);

    void createEmail(RegistroRequest email);

    void updateEmail(RegistroRequest email);

    void deleteEmail(String email);

    void activateEmail(String email);

    void inactivateEmail(String email);
}

