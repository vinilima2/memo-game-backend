package br.com.memogame.game.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.memogame.game.repositories.UsuarioRepo;
import br.com.memogame.game.dtos.UsuarioDto;
import br.com.memogame.game.dtos.UsuarioLoginDto;
import br.com.memogame.game.models.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("usuarios") // --> localhost:8080/usuarios
public class UsuarioController {
    @Autowired
    private UsuarioRepo repo;

    @PostMapping("/login") // --> localhost:8080/usuarios/login # POST
    @ResponseBody
    public UsuarioDto login(@RequestBody UsuarioLoginDto login) {
        Usuario usuario = repo.findByNome(login.nome()); 
        if (usuario == null || !usuario.getSenha().equals(login.senha())) return null; 
        return new UsuarioDto(usuario);
    }
    
}
