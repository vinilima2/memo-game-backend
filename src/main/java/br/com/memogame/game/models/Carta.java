package br.com.memogame.game.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name="carta")
public class Carta {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    @Setter @Getter private Long id;

    @Column(name="cor", nullable = false)
    @Setter @Getter private String cor;

    @Column(name="icone", nullable = false)
    @Setter @Getter private String icone;
}
