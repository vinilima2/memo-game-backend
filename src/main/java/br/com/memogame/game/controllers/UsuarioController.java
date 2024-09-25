package br.com.memogame.game.controllers;

import br.com.memogame.game.dtos.*;
import br.com.memogame.game.services.AuthService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.memogame.game.repositories.RankingRepo;
import br.com.memogame.game.repositories.UsuarioRepo;
import br.com.memogame.game.models.Usuario;
import br.com.memogame.game.models.Ranking;

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
    public LoginResponseDto login(@RequestBody UsuarioLoginDto login, HttpServletResponse response) {
        Usuario usuario = repo.findByNome(login.nome());

        if (usuario == null || !usuario.getSenha().equals(login.senha())) throw new RuntimeException("Usuário ou senha inválidos");

        String token = authService.generateToken(usuario.getNome());

        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);

        return new LoginResponseDto(token);
    }

    @GetMapping("/profile") // --> localhost:8080/usuarios/login # POST
    @ResponseBody
    public UsuarioDto login(@RequestAttribute Claims claims) {
        Usuario usuario = repo.findByNome(claims.get("sub").toString());
        return new UsuarioDto(usuario);
    }
    @PostMapping("/cadastrar") // --> localhost:8080/usuarios/cadastrar # POST
    @ResponseBody
    public UsuarioDto cadastroUsuario(@RequestBody UsuarioCadastroDto novo) {
        if (repo.findByNome(novo.email()) != null || repo.findByEmail(novo.email()) != null) return null;
        Usuario usuario = new Usuario(novo.nome(), novo.email(), novo.senha());
        Ranking ranking = new Ranking(0l);
        usuario.setRanking(ranking);
        ranking.setUsuario(usuario);
        repo.save(usuario);
        rrepo.save(ranking);
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
