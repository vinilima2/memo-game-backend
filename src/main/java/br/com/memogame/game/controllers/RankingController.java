package br.com.memogame.game.controllers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.memogame.game.dtos.RankingDto;
import br.com.memogame.game.repositories.RankingRepo;


@RestController
@RequestMapping("ranking") // --> localhost:8080/ranking
public class RankingController {
    @Autowired
    private RankingRepo repo;

    @GetMapping("/get") // --> localhost:8080/ranking/get
    @ResponseBody
    public List<RankingDto> getAll() {
        return RankingDto.sortRanking(repo.findTop10ByOrderByPontuacaoDesc());
    }

    @GetMapping("/get/{nome}") // --> localhost:8080/ranking/{nome}
    @ResponseBody
    public RankingDto getByNomeUsuario(@PathVariable String nome) {
        return getAll().stream().filter(r -> Objects.equals(r.nome_usuario(), nome)).collect(Collectors.toList()).get(0);
    }
}
