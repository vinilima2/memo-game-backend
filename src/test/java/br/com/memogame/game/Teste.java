package br.com.memogame.game;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import java.util.ArrayList;
//import java.util.List;
//import br.com.memogame.game.repositories.*;
//import br.com.memogame.game.models.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Teste {
    //@Autowired
    //private UsuarioRepo ur;

    //@Autowired
    //private RankingRepo rr;

    //@Autowired
    //private CartaRepo cr;

    @Before
    public void setUp() throws Exception {
        /*List<Usuario> usuarios = new ArrayList<Usuario>();
        List<Ranking> rankings = new ArrayList<Ranking>();
        Usuario u1 = new Usuario("Thomas", "thomas@gmail.com", "hioudfvhioufgs"), u2 = new Usuario("Diego", "lesmarill@hotmail.com", "jadhshuads8123&&das(*)"), u3 = new Usuario("Vinicius", "vinilima81@yahoo.com.br", "adfisuyer234y789"), u4 = new Usuario("Mateus", "mateuzin67@uol.com.br", "1235467fgmnfghj**C&&*V"), u5 = new Usuario("Eduardo", "educomercial@telecom.com.br", "89r234huy7defq7cefr");
        Ranking r1 = new Ranking(90123l), r2 = new Ranking(89123l), r3 = new Ranking(39012391l), r4 = new Ranking(19299l), r5 = new Ranking(100l);
        u1.setRanking(r1);
        u2.setRanking(r2);
        u3.setRanking(r3);
        u4.setRanking(r4);
        u5.setRanking(r5);
        r5.setUsuario(u5);
        r4.setUsuario(u4);
        r3.setUsuario(u3);
        r2.setUsuario(u2);
        r1.setUsuario(u1);
        ur.save(u1); ur.save(u2); ur.save(u3); ur.save(u4); ur.save(u5);
        rr.save(r1); rr.save(r2); rr.save(r3); rr.save(r4); rr.save(r5);
        */
        /*List<Carta> cartas = new ArrayList<Carta>();
        cartas.add(new Carta("estrela", "amarelo"));
        cartas.add(new Carta("quadrado", "vermelho"));
        cartas.add(new Carta("circulo", "roxo"));
        cartas.add(new Carta("coracao", "vermelho"));
        cartas.add(new Carta("quadrado", "verde"));
        cartas.add(new Carta("arvore", "verde"));
        cartas.add(new Carta("gota", "azul"));
        for (Carta c : cartas) {
            cr.save(c);
        }
        */
    }

    @Test
    public void testFetchData(){

    }
}
