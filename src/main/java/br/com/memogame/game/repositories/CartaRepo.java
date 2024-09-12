package br.com.memogame.game.repositories;

import br.com.memogame.game.models.Carta;
import org.springframework.data.repository.CrudRepository;

public interface CartaRepo extends CrudRepository<Carta, Integer> {

}
