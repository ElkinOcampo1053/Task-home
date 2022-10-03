package co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmailResponse {
    private String email;

    private String username;

    private String name;

}
