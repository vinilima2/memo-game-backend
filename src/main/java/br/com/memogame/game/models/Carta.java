package br.com.memogame.game.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="carta")
@NoArgsConstructor
@RequiredArgsConstructor
@Setter @Getter public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "icone", nullable=false)
    @lombok.NonNull
    private String icone;

    @Column(name="cor", nullable = false)
    @lombok.NonNull
    private String cor;
}
