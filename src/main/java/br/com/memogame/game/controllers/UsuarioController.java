package br.com.memogame.game.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.memogame.game.repositories.RankingRepo;
import br.com.memogame.game.repositories.UsuarioRepo;
import br.com.memogame.game.dtos.UsuarioDto;
import br.com.memogame.game.dtos.UsuarioLoginDto;
import br.com.memogame.game.dtos.UsuarioPontuacaoDto;
import br.com.memogame.game.models.Usuario;
import br.com.memogame.game.models.Ranking;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("usuarios") // --> localhost:8080/usuarios
public class UsuarioController {
    @Autowired
    private UsuarioRepo repo;

    @Autowired
    private RankingRepo rrepo;

    @PostMapping("/login") // --> localhost:8080/usuarios/login # POST
    @ResponseBody
    public UsuarioDto login(@RequestBody UsuarioLoginDto login) {
        Usuario usuario = repo.findByNome(login.nome()); 
        if (usuario == null || !usuario.getSenha().equals(login.senha())) return null; 
        return new UsuarioDto(usuario);
    }

    @PostMapping("/novorecorde") // --> localhost:8080/usuarios/novorecorde # POST
    @ResponseBody
    public boolean updatePontuacao(@RequestBody UsuarioPontuacaoDto recorde) {
        Ranking ranking = repo.findByNome(recorde.nome()).getRanking();
        ranking.setPontuacao(recorde.pontuacao());
        rrepo.save(ranking);
        return true;
    }
}
