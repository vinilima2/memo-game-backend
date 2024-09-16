package br.com.memogame.game.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.stream.Collectors;

import br.com.memogame.game.dtos.CartaDto;
import br.com.memogame.game.repositories.CartaRepo;


@RestController
@RequestMapping("cartas") // --> localhost:8080/cartas
public class CartaController {
    @Autowired
    private CartaRepo repo;

    @GetMapping
    public List<CartaDto> getAll() {
        return repo.findAll().stream().map(CartaDto::new).collect(Collectors.toList());
    }
    
}
