package co.edu.utp.misiontic.g12g4.backend.taskhome.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.Usuarios;

public interface RegistroRepository extends JpaRepository<Usuarios, String> {
    Optional<Usuarios> findByEmailAndPasswordAndEstadoIsTrue(String email,String password);

    Optional<Usuarios> findByEmail(String email);
}
