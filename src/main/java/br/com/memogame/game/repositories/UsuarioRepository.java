package br.com.memogame.game.repositories;

import org.springframework.data.repository.CrudRepository;
import br.com.memogame.game.models.Usuario;
import br.com.memogame.game.models.Ranking;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

}
