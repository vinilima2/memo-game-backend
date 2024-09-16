package br.com.memogame.game.dtos;

import br.com.memogame.game.models.Carta;

public record CartaDto(long id, String icone, String cor) {  
    public CartaDto(Carta carta) {
        this(carta.getId(), carta.getIcone(), carta.getCor());
    }
}
