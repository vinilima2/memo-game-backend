package br.com.memogame.game.repositories;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import br.com.memogame.game.models.Ranking;

public interface RankingRepo extends CrudRepository<Ranking, Integer> {
    List<Ranking> findAll();
    Ranking findById(long id);
}
