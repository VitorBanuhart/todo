package com.todo.todo.dto.tarefa;

import java.time.LocalDate;

import com.todo.todo.enums.Prioridade;
import com.todo.todo.enums.Status;
import com.todo.todo.model.Tarefas;

import lombok.Getter;

@Getter
public class TarefaDTO {
    private String nomeTarefa;
    private String descTarefa;
    private LocalDate dataLimite;
    private Prioridade prioridade; 
    private Status status;
    private Long usuarioId;

    public Tarefas transformaParaObjeto() {
        return new Tarefas(nomeTarefa, descTarefa, dataLimite, prioridade, status, usuarioId);
    }
}
