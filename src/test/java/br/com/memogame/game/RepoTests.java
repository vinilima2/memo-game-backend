package br.com.memogame.game;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.memogame.game.models.Usuario;
import br.com.memogame.game.models.Ranking;
import br.com.memogame.game.models.Carta;
import br.com.memogame.game.repositories.UsuarioRepo;
import br.com.memogame.game.repositories.RankingRepo;
import br.com.memogame.game.repositories.CartaRepo;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepoTests {
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private RankingRepo rankingRepo;

    @Autowired
    private CartaRepo cartaRepo;

    @Before
    public void iniciaClasses() throws Exception {
        
    }

    @Test
    public void testaCRUD(){

    }
}
