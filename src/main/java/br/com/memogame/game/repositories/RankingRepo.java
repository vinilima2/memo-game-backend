package br.com.memogame.game.repositories;

import br.com.memogame.game.dtos.RankingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import br.com.memogame.game.models.Ranking;
import br.com.memogame.game.models.Usuario;
import org.springframework.data.repository.query.Param;

public interface RankingRepo extends CrudRepository<Ranking, Long> {
    List<Ranking> findAll();
    List<Ranking> findTop10ByOrderByPontuacaoDesc();
    Ranking findById(long id);
    Ranking findByUsuario(Usuario usuario);
    @Query(name = "buscaRankingGlobal", nativeQuery = true)
    List<RankingDto> findTop10WithUsuarioLogado(@Param("userId") long userId);
}
