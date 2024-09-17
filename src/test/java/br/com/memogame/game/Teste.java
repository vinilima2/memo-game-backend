package br.com.memogame.game;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
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
        List<Carta> cartas = new ArrayList<Carta>();
        cartas.add(new Carta("aviao", "amarelo"));
        cartas.add(new Carta("panela", "azul"));
        cartas.add(new Carta("estrela", "vermelha"));
        cartas.add(new Carta("quadrado", "rosa"));
        cartas.add(new Carta("triangulo", "verde"));
        for (Carta carta : cartas) {
            cr.save(carta);
        }
    }

    @Test
    public void testFetchData(){

    }
}
