package br.com.memogame.game.repositories;

import org.springframework.data.repository.CrudRepository;
import br.com.memogame.game.models.Usuario;
import br.com.memogame.game.models.Ranking;
import java.util.List;


public interface UsuarioRepo extends CrudRepository<Usuario, Integer> {
   List<Usuario> findAll();
   Usuario findById(long id);
   Usuario findByNome(String nome);
   Usuario findByRanking(Ranking ranking);
}
