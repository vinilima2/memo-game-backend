package br.com.memogame.game.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import br.com.memogame.game.dtos.CartaDto;
import br.com.memogame.game.repositories.CartaRepo;


@RestController
@RequestMapping("cartas") // --> localhost:8080/cartas
public class CartaController {
    @Autowired
    private CartaRepo repo;

    @GetMapping("/get") // --> localhost:8080/cartas/get
    @ResponseBody
    public List<CartaDto> getAll() {
        return repo.findAll().stream().map(CartaDto::new).collect(Collectors.toList());
    }

    @GetMapping("/get/random") // -> localhost:8080/cartas/get/random?qtd=
    @ResponseBody
    public List<CartaDto> getRandom(@RequestParam int qtd) {
        List<CartaDto> cartas = repo.findAll().stream().map(CartaDto::new).collect(Collectors.toList());
        if (qtd <= 0) return List.of();
        if (qtd >= cartas.size()) return cartas; 
        Random rand = new Random(System.currentTimeMillis());
        while(cartas.size() != qtd) cartas.remove(rand.nextInt(cartas.size()));
        return cartas;
    }
    
    @GetMapping("/get/id") //--> localhost:8080/cartas/get/id?id=
    @ResponseBody
    public CartaDto getById(@RequestParam final long id) {
        return new CartaDto(repo.findById(id));
    }

    @GetMapping("/get/icone") // --> localhost:8080/cartas/get/icone?icone=
    @ResponseBody
    public List<CartaDto> getByIcone(@RequestParam final String icone) {
        return repo.findByIcone(icone).stream().map(CartaDto::new).collect(Collectors.toList());
    }
}
