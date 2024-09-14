package br.com.memogame.game.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter public class UsuarioPostDTO {
    @JsonProperty("id")
    private long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("email")
    @Email
    private String email;

    @JsonProperty("Senha")
    private String senha;

    @JsonProperty("ranking")
    private RankingDTO ranking;
}
