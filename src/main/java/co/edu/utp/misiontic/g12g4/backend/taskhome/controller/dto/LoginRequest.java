package co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
    private String name;
}
