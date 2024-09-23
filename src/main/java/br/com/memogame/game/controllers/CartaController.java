package br.com.memogame.game.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
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
    public List<CartaDto> getRandom(@RequestParam int qtd) throws InterruptedException {
        return buscarCartasAleatorias(qtd);
    }

    private List<CartaDto> buscarCartasAleatorias(int qtd) {
        List<CartaDto> todasCartas = new ArrayList<>(repo.findAll().stream().map(CartaDto::new).toList());
        Collections.shuffle(todasCartas);
        List<CartaDto> cartasTotais = todasCartas.stream().limit(qtd).toList();
        List<CartaDto> cartasMisturadas = new ArrayList<>();
        cartasTotais.forEach(carta ->{
            cartasMisturadas.add(carta);
            cartasMisturadas.add(carta);
        });
        Collections.shuffle(cartasMisturadas);
        return cartasMisturadas;
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
