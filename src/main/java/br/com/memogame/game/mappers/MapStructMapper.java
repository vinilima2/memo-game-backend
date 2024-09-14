package br.com.memogame.game.mappers;

import org.mapstruct.Mapper;

import br.com.memogame.game.dtos.*;
import br.com.memogame.game.models.*;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    CartaDTO cartaToCartaDTO(Carta carta);
    Carta cartaDTOToCarta(CartaDTO cartaDTO);
    RankingDTO rankingToRankingDTO(Ranking ranking);
    Ranking rankingDTOToRanking(RankingDTO rankingDTO);
    UsuarioGetDTO usuarioToUsuarioGetDTO(Usuario usuario);
    UsuarioPostDTO usuarioToUsuarioPostDTO(Usuario usuario);
    Usuario usuarioGetDTOToUsuario(UsuarioGetDTO usuarioGetDTO);
    Usuario usuarioPostDTOTUsuario(UsuarioPostDTO usuarioPostDTO);
}
