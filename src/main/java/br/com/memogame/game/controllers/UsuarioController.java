package br.com.memogame.game.controllers;

import br.com.memogame.game.services.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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

    @Autowired
    private AuthService authService;

    @PostMapping("/login") // --> localhost:8080/usuarios/login # POST
    @ResponseBody
    public UsuarioDto login(@RequestBody UsuarioLoginDto login, HttpServletResponse response) {
        Usuario usuario = repo.findByNome(login.nome());

        if (usuario == null || !usuario.getSenha().equals(login.senha())) throw new RuntimeException("Usuário ou senha inválidos");

        String token = authService.generateToken(usuario.getNome());

        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);

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
