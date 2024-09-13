package br.com.memogame.game.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="carta")
@Setter @Getter public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "icone", nullable=false)
    private String icone;

    @Column(name="cor", nullable = false)
    private String cor;

    public Carta() {  }
    public Carta(final String icone, final String cor) {
        this.icone = icone;
        this.cor = cor;
    }
}
