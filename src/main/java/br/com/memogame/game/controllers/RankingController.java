package br.com.memogame.game.controllers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.memogame.game.models.Ranking;
import br.com.memogame.game.models.Usuario;
import br.com.memogame.game.repositories.UsuarioRepo;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.memogame.game.dtos.RankingDto;
import br.com.memogame.game.repositories.RankingRepo;


@RestController
@RequestMapping("ranking") // --> localhost:8080/ranking
public class RankingController {
    @Autowired
    private RankingRepo repo;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @GetMapping("/get") // --> localhost:8080/ranking/get
    @ResponseBody
    public List<RankingDto> getAll(@RequestAttribute Claims claims) {
        String username = claims.get("sub").toString();
        Usuario usuario = usuarioRepo.findByNome(username);
        return repo.findTop10WithUsuarioLogado(usuario.getId());
    }

    @GetMapping("/get/{nome}") // --> localhost:8080/ranking/{nome}
    @ResponseBody
    public RankingDto getByNomeUsuario(@RequestAttribute Claims claims) {
        String username = claims.get("sub").toString();
        Usuario usuario = usuarioRepo.findByNome(username);
        Ranking rankingUsuario = repo.findByUsuario(usuario);
        return new RankingDto(rankingUsuario);
    }
}
