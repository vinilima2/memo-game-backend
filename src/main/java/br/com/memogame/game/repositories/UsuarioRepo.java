package br.com.memogame.game.repositories;

import br.com.memogame.game.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepo extends CrudRepository<Usuario, Integer> {
    
}
