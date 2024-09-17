package br.com.memogame.game.dtos;

import br.com.memogame.game.models.Ranking;

public record RankingDto(long id, Long pontuacao, String nome_usuario) {
    public RankingDto(Ranking ranking) {
        this(ranking.getId(), ranking.getPontuacao(), ranking.getUsuario().getNome());
    }
}
