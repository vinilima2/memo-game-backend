package br.com.memogame.game.repositories;

import org.springframework.data.repository.CrudRepository;
import br.com.memogame.game.models.Carta;


public interface CartaRepository extends CrudRepository<Carta, Integer> {

}
