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

    @Before
    public void setUp() throws Exception {
        Usuario usuario = new Usuario("Thomas", "thomasbradesco55@gmail.com", "bhasd&&aasd9012ijnhu78");
        Ranking ranking = new Ranking(1000);
        usuario.setRanking(ranking);
        ranking.setUsuario(usuario);
        ur.save(usuario);
        rr.save(ranking);
    }

    @Test
    public void testFetchData(){
        Ranking ranking = rr.findById(1);
        Assert.assertNotNull(ranking); 
        Usuario usuario = ur.findByRanking(ranking);
        Assert.assertNotNull(usuario);   
        Assert.assertEquals(usuario.getId(), 1);
        Assert.assertEquals(usuario.getNome(), "Thomas");
    }
}
