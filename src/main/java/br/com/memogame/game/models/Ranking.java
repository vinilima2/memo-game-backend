package br.com.memogame.game.models;

import br.com.memogame.game.dtos.RankingDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="ranking")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@NamedNativeQuery(
    name = "buscaRankingGlobal",
    query = "select usuario.nome as nome, pontos, rank from (select pontuacao as pontos, usuario_id, global_rank.`rank` as \"rank\" from (select *, ROW_NUMBER() OVER (ORDER BY pontuacao DESC) as \"rank\" from ranking limit 10) global_rank union select pontuacao as pontos, usuario_id, local_rank.`rank` as \"rank\" from (select *, ROW_NUMBER() OVER (ORDER BY pontuacao DESC) as \"rank\" from ranking) local_rank where local_rank.usuario_id = :userId) as externo left join usuario on usuario.id = externo.usuario_id",
    resultSetMapping = "ranking_map"
)
@SqlResultSetMapping(
    name = "ranking_map",
    classes = @ConstructorResult(
            targetClass = RankingDto.class,
            columns = {
                    @ColumnResult(name = "pontos", type = Long.class),
                    @ColumnResult(name = "nome", type = String.class),
                    @ColumnResult(name = "rank", type = Integer.class)
            }
    )
)
@Setter @Getter public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="pontuacao", nullable=false)
    @lombok.NonNull
    private Long pontuacao;

    @Column(name="posicao")
    private Integer posicao = 0;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

}
