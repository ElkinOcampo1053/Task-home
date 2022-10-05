package co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "grupo_familiar")
public class GrupoFamiliar implements Serializable{
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int id_configuracion;
    private String nombre_grupo_familiar;
}
