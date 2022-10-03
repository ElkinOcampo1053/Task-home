package co.edu.utp.misiontic.g12g4.backend.taskhome.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.utp.misiontic.g12g4.backend.taskhome.model.entity.User;

public interface EmailRepository extends JpaRepository<User, String> {
    Optional<User> findByEmailAndPasswordAndActiveIsTrue(String email, String password);

    Optional<User> findByEmail(String email);
}
