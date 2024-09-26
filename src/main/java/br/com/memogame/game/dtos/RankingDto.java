package br.com.memogame.game.dtos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import br.com.memogame.game.models.Ranking;

public record RankingDto(Long pontos, String nome, Integer rank) {
    public RankingDto(final Ranking ranking) {
        this(ranking.getPontuacao(), ranking.getUsuario().getNome(), ranking.getPosicao());
    }
    public static List<RankingDto> sortRanking(List<Ranking> ranking) {
        return ranking.stream().map(RankingDto::new).collect(Collectors.toList());
    }
}
