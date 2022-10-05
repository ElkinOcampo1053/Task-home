package co.edu.utp.misiontic.g12g4.backend.taskhome.controller.dto;

import lombok.Data;

public class RegistroDto {
    private int id;
    private String nombre_usuario;
    private String password;
    private String correo_electronico;
    private String fecha_nacimiento;
    private int id_grupo_familiar;
    private int id_rol_grupo_familiar;
    private int tiempo_disponibilidad;
    private boolean estado;
}
