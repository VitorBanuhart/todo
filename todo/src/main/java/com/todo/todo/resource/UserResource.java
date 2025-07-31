package com.todo.todo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todo.dto.usuario.LoginUsuarioDTO;
import com.todo.todo.dto.usuario.UsuarioDTO;
import com.todo.todo.service.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserResource {
    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Void> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        System.out.println(usuarioDTO.getEmail());
        System.out.println(usuarioDTO.getNome());
        System.out.println(usuarioDTO.getIdade());
        
        service.createUser(usuarioDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Long> loginUsuario(@RequestBody LoginUsuarioDTO usuarioDTO) {
        Long id = service.searchForID(usuarioDTO); 
        new ResponseEntity<>(HttpStatus.ACCEPTED);
        return ResponseEntity.ok().body(id);
    }
    
}
