package com.todo.todo.service;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todo.dto.tarefa.TarefaDTO;
import com.todo.todo.enums.Status;
import com.todo.todo.model.Tarefas;
import com.todo.todo.repository.TarefasRepository;

@Service
public class TarefasService {
    @Autowired
    private TarefasRepository repo;

    public void createTask(TarefaDTO novaTarefaDTO) {
        Tarefas tarefa = Tarefas.builder()
            .nomeTarefa(novaTarefaDTO.getNomeTarefa())
            .descTarefa(novaTarefaDTO.getDescTarefa())
            .dataLimite(novaTarefaDTO.getDataLimite())
            .prioridade(novaTarefaDTO.getPrioridade())
            .status(Status.EM_ANDAMENTO)
            .usuarioId(novaTarefaDTO.getUsuarioId())
        .build();

        repo.save(tarefa);
    }

    public Tarefas editTask(Tarefas obj){
        Tarefas tarefa = findById(obj.getId());

        tarefa.setId(obj.getId());
        tarefa.setNomeTarefa(obj.getNomeTarefa());
        tarefa.setDescTarefa(obj.getDescTarefa());
        tarefa.setPrioridade(obj.getPrioridade());
        tarefa.setStatus(obj.getStatus());

        return repo.save(tarefa);
    }

    public Tarefas findById(Long id) {
        Optional<Tarefas> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado", obj));
    }
}
