package co.edu.utp.misiontic.g12g4.backend.taskhome.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dto.RegistroRequest;
import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dto.RegistroResponse;
import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.Usuarios;
import co.edu.utp.misiontic.g12g4.backend.taskhome.model.repository.RegistroRepository;
import co.edu.utp.misiontic.g12g4.backend.taskhome.service.RegistroService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistroServiceImpl implements RegistroService{
    private final RegistroRepository registroRepository;

    @Override
    public RegistroResponse validateRegistro(String email) {
        var registroOp = registroRepository.findByEmail(email);
        if (registroOp.isEmpty()) {
        throw new RuntimeException("Correo Electronico no existente");
        }

      var correo = registroOp.get();
       return RegistroResponse.builder()
               .email(correo.getEmail())        
               .username(correo.getNombre_usuario())
               .build();
   }

    @Override
    public RegistroResponse getUserByEmail(String email) {
        var EmailOp = registroRepository.findByEmail(email);
        if (EmailOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        var Email = EmailOp.get();
        return RegistroResponse.builder()
                .username(Email.getNombre_usuario())
                .email(Email.getEmail())
                .build();
    }

    @Override
    public void createEmail(RegistroRequest email) {

        var emailOp = registroRepository.findByEmail(email.getEmail());
        if (emailOp.isPresent()) {
            throw new RuntimeException("No puede utilizar ese nombre de usuario");
        }

        emailOp = registroRepository.findByEmail(email.getEmail());
        if (emailOp.isPresent()) {
            throw new RuntimeException("Ya existe un usuario registrado con ese correo electrónico");
        }

        var emailDb = new Usuarios();
        emailDb.setNombre_usuario(email.getUsername());
        emailDb.setPassword(email.getPassword());
        emailDb.setEmail(email.getEmail());
        emailDb.setEstado(true);
        emailDb = registroRepository.save(emailDb);

    }

    @Override
    public void updateEmail(RegistroRequest Email) {
        var EmailOp = registroRepository.findByEmail(Email.getEmail());
        if (EmailOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        var emailDb = EmailOp.get();
        emailDb.setNombre_usuario(Email.getUsername());
        emailDb.setEmail(Email.getEmail());
        emailDb = registroRepository.save(emailDb);
    }

    @Override
    public void deleteEmail(String email) {
        var emailOp = registroRepository.findByEmail(email);
        if (emailOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        registroRepository.delete(emailOp.get());
    }

    @Override
    public void activateEmail(String email) {
        var emailOp = registroRepository.findByEmail(email);
        if (emailOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        var Email = emailOp.get();
        Email.setEstado(true);
        registroRepository.save(Email);
    }

    @Override
    public void inactivateEmail(String email) {
        var emailOp = registroRepository.findById(email);
        if (emailOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        var Email = emailOp.get();
        Email.setEstado(true);
        registroRepository.save(Email);

    }
}
