package br.com.memogame.game.dtos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.com.memogame.game.models.Ranking;

public record RankingDto(long id, Long pontuacao, String nome_usuario, int posicao) {
    public RankingDto(final Ranking ranking) {
        this(ranking.getId(), ranking.getPontuacao(), ranking.getUsuario().getNome(), ranking.getPosicao());
    }
    public static List<RankingDto> sortRanking(List<Ranking> ranking) {
        Collections.sort(ranking, (a, b) -> {
            return (int) (b.getPontuacao() - a.getPontuacao());
        });
        Ranking[] temp = ranking.stream().toArray(Ranking[]::new);
        for (int x=1; x <= ranking.size(); x++) temp[x-1].setPosicao(x);
        return Arrays.asList(temp).stream().map(RankingDto::new).collect(Collectors.toList());
    }
}
