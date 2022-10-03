package co.edu.utp.misiontic.g12g4.backend.taskhome.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dto.LoginRequest;
import co.edu.utp.misiontic.g12g4.backend.taskhome.service.SecurityService;
import lombok.AllArgsConstructor;
import lombok.var;

@AllArgsConstructor
@RestController
@RequestMapping("api/login")
public class LoginRestController {

    // POST -> Insertar (C)
    // GET -> Consultar / Listar (R)
    // PUT -> Actualizar (U)
    // PATCH -> Actualizar Campo
    // DELETE -> Borrar (D)

    private final SecurityService securityService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest email) {
        try {
            var response = securityService.validateEmail(email.getEmail(), email.getPassword());
            return ResponseEntity.ok(response);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

    @PostMapping("/fake")
    public ResponseEntity<?> fakeLogin() {
        return ResponseEntity.badRequest().build();
    }

}
