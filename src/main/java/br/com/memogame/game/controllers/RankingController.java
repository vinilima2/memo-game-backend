package br.com.memogame.game.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.memogame.game.dtos.RankingDto;
import br.com.memogame.game.repositories.RankingRepo;

@RestController
@RequestMapping("ranking") // --> localhost:8080/ranking
public class RankingController {
    @Autowired
    private RankingRepo repo;

    @GetMapping("/get") // --> localhost:8080/ranking/get
    public List<RankingDto> getAll() {
        return repo.findAll().stream().map(RankingDto::new).collect(Collectors.toList());
    }
}
