package co.edu.utp.misiontic.g12g4.backend.taskhome.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dto.EmailRequest;
import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dto.EmailResponse;
import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.User;
import co.edu.utp.misiontic.g12g4.backend.taskhome.model.repository.EmailRepository;
import co.edu.utp.misiontic.g12g4.backend.taskhome.service.SecurityService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final EmailRepository emailRepository;

    @Override
    public EmailResponse validateEmail(String email, String password) {
         var emailOp = emailRepository.findByEmail(email);
         if (emailOp.isEmpty()) {
         throw new RuntimeException("Correo Electronico no existente");
         }

         var Email = emailOp.get();
         if (!Email.getActive()) {
         throw new RuntimeException("Usuario inactivo");
         }

         if (!Email.getPassword().equals(password)) {
        throw new RuntimeException("Credenciales inválidas");
         }

       var correo = emailOp.get();
        return EmailResponse.builder()
                .email(correo.getEmail())        
                .username(correo.getNombreusuario())
                .name(correo.getLoginusuario())
                .build();
    }

    @Override
    public List<EmailResponse> getAllEmail() {
        return emailRepository.findAll().stream()
                .map(u -> EmailResponse.builder()
                        .username(u.getNombreusuario())
                        .name(u.getLoginusuario())
                        .email(u.getEmail())
                        //.admin(u.getAdmin())
                        .build())
                .collect(Collectors.toList());
    }
    
    @Override
    public EmailResponse getUserByEmail(String email) {
        var EmailOp = emailRepository.findByEmail(email);
        if (EmailOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        var Email = EmailOp.get();
        return EmailResponse.builder()
                .username(Email.getNombreusuario())
                .name(Email.getLoginusuario())
                .email(Email.getEmail())
                .build();
    }

    @Override
    public void createEmail(EmailRequest email) {

        var emailOp = emailRepository.findByEmail(email.getEmail());
        if (emailOp.isPresent()) {
            throw new RuntimeException("No puede utilizar ese nombre de usuario");
        }

        emailOp = emailRepository.findByEmail(email.getEmail());
        if (emailOp.isPresent()) {
            throw new RuntimeException("Ya existe un usuario registrado con ese correo electrónico");
        }

        var emailDb = new User();
        emailDb.setNombreusuario(email.getUsername());
        emailDb.setPassword(email.getPassword());
        emailDb.setLoginusuario(email.getName());
        emailDb.setEmail(email.getEmail());
        emailDb.setActive(true);
        emailDb = emailRepository.save(emailDb);

    }

    @Override
    public void updateEmail(EmailRequest Email) {
        var EmailOp = emailRepository.findByEmail(Email.getEmail());
        if (EmailOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        var emailDb = EmailOp.get();
        emailDb.setNombreusuario(Email.getUsername());
        emailDb.setLoginusuario(Email.getName());
        emailDb.setEmail(Email.getEmail());
        emailDb = emailRepository.save(emailDb);
    }

    @Override
    public void deleteEmail(String email) {
        var emailOp = emailRepository.findByEmail(email);
        if (emailOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        emailRepository.delete(emailOp.get());
    }

    @Override
    public void activateEmail(String email) {
        var emailOp = emailRepository.findByEmail(email);
        if (emailOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        var Email = emailOp.get();
        Email.setActive(true);
        emailRepository.save(Email);
    }

    @Override
    public void inactivateEmail(String email) {
        var emailOp = emailRepository.findById(email);
        if (emailOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        var Email = emailOp.get();
        Email.setActive(false);
        emailRepository.save(Email);

    }
}
