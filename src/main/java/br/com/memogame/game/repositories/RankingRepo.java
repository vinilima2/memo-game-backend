package br.com.memogame.game.repositories;

import br.com.memogame.game.models.Ranking;
import org.springframework.data.repository.CrudRepository;

public interface RankingRepo extends CrudRepository<Ranking, Integer> {

}
