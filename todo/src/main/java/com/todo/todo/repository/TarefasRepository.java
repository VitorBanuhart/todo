package com.todo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.todo.model.Tarefas;
import java.util.List;


public interface TarefasRepository extends JpaRepository<Tarefas, Long>{
    List<Tarefas> findByUsuarioId(Long usuarioId);
} 
