package br.com.memogame.game.repositories;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import br.com.memogame.game.models.Ranking;
import br.com.memogame.game.models.Usuario;

public interface RankingRepo extends CrudRepository<Ranking, Integer> {
    List<Ranking> findAll();
    List<Ranking> findTop10ByOrderByPontuacaoDesc();
    Ranking findById(long id);
    Ranking findByUsuario(Usuario usuario);
}
