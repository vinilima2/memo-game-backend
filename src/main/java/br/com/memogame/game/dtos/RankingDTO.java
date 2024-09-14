package br.com.memogame.game.dtos;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Setter @Getter public class RankingDTO { 
    @JsonProperty("id")
    private long id;

    @JsonProperty("pontuacao")
    private Long pontuacao;
}
