package br.com.memogame.game.dtos;

import br.com.memogame.game.models.Usuario;

public record UsuarioDto (long id, String nome, String email, long pontuacao) {
    public UsuarioDto(final Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getRanking().getPontuacao());
    }
}
