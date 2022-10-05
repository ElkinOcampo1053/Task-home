package co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "registro_tareas")
public class RegistroTareas implements Serializable{

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fecha_estimada_ejecucion;
    private String hora_estimada_ejecucion;
    private int id_tarea;
    private int id_usuario;
    private int id_grupo_familiar;  
    private String observaciones;  
    private String fecha_finalizacion;
    private String hora_finalizacion;    
    private String finalizado;
}
