package com.todo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.todo.model.Tarefas;

public interface TarefasRepository extends JpaRepository<Tarefas, Long>{
    
} 
