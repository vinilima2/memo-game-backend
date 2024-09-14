package br.com.memogame.game.dtos;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Setter @Getter public class CartaDTO {
    @JsonProperty("id")
    private long id;

    @JsonProperty("icone")
    private String icone;

    @JsonProperty("cor")
    private String cor;
}
