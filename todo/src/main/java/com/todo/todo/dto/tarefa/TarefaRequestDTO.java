package com.todo.todo.dto.tarefa;

import java.time.LocalDate;

import com.todo.todo.enums.Prioridade;
import com.todo.todo.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TarefaRequestDTO {
    private Long id;
    private String nomeTarefa;
    private String descTarefa;
    private LocalDate dataLimite;
    private Prioridade prioridade;
    private Status status;
}
