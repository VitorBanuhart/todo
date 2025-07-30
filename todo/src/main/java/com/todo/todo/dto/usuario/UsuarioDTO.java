package com.todo.todo.dto.usuario;

import com.todo.todo.model.Usuario;

import lombok.Getter;

@Getter
public class UsuarioDTO {
    
    private String nome;
    private Integer idade;
    private String email;

    public Usuario transformaParaObjeto() {
        return new Usuario(null, nome, idade, email);
    }
}
