package com.todo.todo.model;

import java.time.LocalDate;

import com.todo.todo.dto.tarefa.TarefaRequestDTO;
import com.todo.todo.enums.Prioridade;
import com.todo.todo.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tarefas")
@Builder
public class Tarefas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome_tarefa", nullable = false)
    private String nomeTarefa;

    @Column(name = "desc_tarefa", nullable = false)
    private String descTarefa;

    @Column(name = "data_limite")
    private LocalDate dataLimite;

    @Column(name = "prioridade") 
    private Prioridade prioridade;

    @Column(name = "status")
    private Status status;

    @Column(name = "usuario_id")
    private Long usuarioId;

    public Tarefas(String nometarefa, String descTarefa, LocalDate dataLimite, Prioridade prioridade, Status status, Long usuarioId){
        this.nomeTarefa = nometarefa;
        this.descTarefa = descTarefa;
        this.dataLimite = dataLimite;
        this.prioridade = prioridade;
        this.status = status;
        this.usuarioId = usuarioId;
    }

    public Tarefas(TarefaRequestDTO obj) {
        this.nomeTarefa = obj.getNomeTarefa();
        this.descTarefa = obj.getDescTarefa();
        this.prioridade = obj.getPrioridade();
        this.status = obj.getStatus();
        this.dataLimite = obj.getDataLimite();
    }
}
