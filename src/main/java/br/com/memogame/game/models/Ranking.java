package br.com.memogame.game.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name="ranking")
public class Ranking {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    @Setter @Getter private Long id;

    @OneToOne(mappedBy = "ranking")
    @Setter @Getter private Usuario usuario;
}
