package co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios  implements Serializable{
   
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String nombre_usuario; // user_name
    
    private String password;
    
    @Column(name = "correo_electronico")
    private String email;

    private String fecha_nacimiento;

    private String id_grupo_familiar;

    private String id_rol_usuario;

    private String tiempo_disponibilidad;

    private Boolean estado;
    
}
