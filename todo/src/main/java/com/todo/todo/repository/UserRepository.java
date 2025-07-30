package com.todo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.todo.model.Usuario;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String string);
}
