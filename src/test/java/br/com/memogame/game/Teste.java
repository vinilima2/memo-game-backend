package br.com.memogame.game;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.memogame.game.repositories.*;
import br.com.memogame.game.models.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Teste {
    @Autowired
    private UsuarioRepo ur;

    @Autowired
    private RankingRepo rr;

    @Autowired
    private CartaRepo cr;

    @Before
    public void setUp() throws Exception {
        Carta carta = new Carta("bomba", "preto");
        cr.save(carta);
    }

    @Test
    public void testFetchData(){

    }
}
