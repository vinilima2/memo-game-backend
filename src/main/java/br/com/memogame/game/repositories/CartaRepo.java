package br.com.memogame.game.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.com.memogame.game.models.Carta;

public interface CartaRepo extends CrudRepository<Carta, Integer> {
    List<Carta> findAll();
    Carta findById(long id);
    List<Carta> findByIcone(String icone);
    List<Carta> findByCor(String cor);
}
