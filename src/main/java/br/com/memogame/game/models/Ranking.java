package br.com.memogame.game.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name="ranking")
@Setter @Getter public class Ranking {
    @Id
    @Column(name = "usuario_id")
    private int id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "pontuacao", nullable = false)
    private long pontuacao = 0;
}