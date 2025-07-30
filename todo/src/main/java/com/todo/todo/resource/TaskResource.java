package com.todo.todo.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todo.dto.tarefa.TarefaDTO;
import com.todo.todo.dto.tarefa.TarefaRequestDTO;
import com.todo.todo.model.Tarefas;
import com.todo.todo.repository.TarefasRepository;
import com.todo.todo.service.TarefasService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "/tasks")
public class TaskResource {

    @Autowired
    private TarefasService service;

    @Autowired
    private TarefasRepository repo;

    @PostMapping("/new")
    public ResponseEntity<Void> newTask(@RequestBody TarefaDTO novaTarefaDTO) {
        service.createTask(novaTarefaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> postMethodName(@RequestBody TarefaRequestDTO entity, @PathVariable Long id) {
        Tarefas uptTarefas = new Tarefas(entity);
        uptTarefas.setId(id);
        uptTarefas = service.editTask(uptTarefas);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
        Tarefas obj = service.findById(id);
        repo.delete(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Tarefas>> getTasks(@PathVariable Long id) {
        List<Tarefas> listaTarefas = new ArrayList<>();
        listaTarefas = repo.findByUsuarioId(id);
        return ResponseEntity.ok().body(listaTarefas);
    }

}
