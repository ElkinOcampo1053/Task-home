package co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id

    @Column(name = "nombre_usuario")
    private String nombreusuario; // user_name

    @Column(name = "login_usuario")
    private String loginusuario; // user_name
    
    private String password;
    
    @Column(name = "correo_electronico", unique = true)
    private String email;

    @Column(name = "fecha_nacimiento", unique = true)
    private String fechanacimiento;

    @Column(name = "id_grupo_familia")
    private String idgrupofamiliar;

    @Column(name = "id_rol_grupo_familia")
    private String idrolgrupofamiliar;
    
    private String tiempo_disponibilidad;
    
    @Column(name = "estado")
    private Boolean active;
    
    @Column(name = "id")
    private int idusuario;

}
