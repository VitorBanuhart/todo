package com.todo.todo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todo.dto.usuario.LoginUsuarioDTO;
import com.todo.todo.dto.usuario.UsuarioDTO;
import com.todo.todo.model.Usuario;
import com.todo.todo.repository.UserRepository;

@Service
public class UsuarioService {
    @Autowired
    private UserRepository repo;

    public void createUser(UsuarioDTO usuarioDTO) {
        if (repo.existsByEmail(usuarioDTO.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        Usuario usuario = Usuario.builder()
            .nome(usuarioDTO.getNome())
            .email(usuarioDTO.getEmail())
            .idade(usuarioDTO.getIdade())
            .build();

        System.out.println(usuarioDTO.getNome());
        System.out.println(usuarioDTO.getEmail());
        System.out.println(usuarioDTO.getIdade());

        repo.save(usuario);
    
    }

    public Long searchForID(LoginUsuarioDTO loginUsuarioDTO) {
        Optional<Usuario> usuario = repo.findByEmail(loginUsuarioDTO.getEmail());
        if (usuario.isPresent()) {
            Usuario usuarioLogin = usuario.get();
            return usuarioLogin.getId();
        } else {
            return null;
        }
        
    }
}
