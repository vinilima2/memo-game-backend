package br.com.memogame.game.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.Getter;


@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    @Setter @Getter private Long id;

    @Column(name="nome", nullable = false, unique = true)
    @Setter @Getter private String nome;

    @Column(name="email", nullable = false)
    @Setter @Getter private String email;

    @Column(name="senha", nullable = false)
    @Setter @Getter private String senha;

    @Column(name="recorde", nullable = false)
    @Setter @Getter private Long recorde;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ranking_id", referencedColumnName = "id")
    @Setter @Getter private Ranking ranking;
}
