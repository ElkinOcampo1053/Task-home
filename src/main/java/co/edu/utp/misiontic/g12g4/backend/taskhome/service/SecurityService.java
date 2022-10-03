package co.edu.utp.misiontic.g12g4.backend.taskhome.service;

import java.util.List;

import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dto.EmailRequest;
import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dto.EmailResponse;

public interface SecurityService {

    EmailResponse validateEmail(String email, String password);

    List<EmailResponse> getAllEmail();

    EmailResponse getUserByEmail(String email);

    void createEmail(EmailRequest email);

    void updateEmail(EmailRequest email);

    void deleteEmail(String email);

    void activateEmail(String email);

    void inactivateEmail(String email);
}
