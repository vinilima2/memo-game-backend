package br.com.memogame.game.repositories;

import org.springframework.data.repository.CrudRepository;
import br.com.memogame.game.models.Ranking;
import br.com.memogame.game.models.Usuario;

public interface RankingRepository extends CrudRepository<Ranking, Integer> {
    
}
