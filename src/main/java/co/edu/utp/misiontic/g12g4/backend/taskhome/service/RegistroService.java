package co.edu.utp.misiontic.g12g4.backend.taskhome.service;

import java.util.List;

import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dto.EmailRequest;
import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dto.EmailResponse;

public interface RegistroService {

    EmailResponse validateEmail(String correo);

    List<EmailResponse> getAllUsers();

    EmailResponse getUserByUsername(String username);

    void createUser(EmailRequest user);

    void updateUser(EmailRequest user);

    void deleteUser(String email);

    void activateUser(String email);

    void inactivateUser(String email);
}
