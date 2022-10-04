package co.edu.utp.misiontic.g12g4.backend.taskhome.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dto.RegistroRequest;
import co.edu.utp.misiontic.g12g4.backend.taskhome.service.RegistroService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/registro")
public class RegistroRestController {
    // POST -> Insertar (C)
    // GET -> Consultar / Listar (R)
    // PUT -> Actualizar (U)
    // PATCH -> Actualizar Campo
    // DELETE -> Borrar (D)

    private final RegistroService registroService;

    @PostMapping
    public ResponseEntity<?> registro(@RequestBody RegistroRequest email) { 
        try {
            var response = registroService.validateRegistro(email.getEmail());
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
