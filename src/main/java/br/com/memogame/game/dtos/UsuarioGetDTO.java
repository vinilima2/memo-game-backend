package br.com.memogame.game.dtos;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Setter @Getter public class UsuarioGetDTO {
    @JsonProperty("id")
    private long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("ranking")
    private RankingDTO ranking;
}
