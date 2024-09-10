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
@Setter @Getter public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="nome", nullable = false, unique = true)
    private String nome;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="senha", nullable = false)
    private String senha;

    @Column(name="recorde", nullable = false)
    private Long recorde;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ranking_id", referencedColumnName = "id")
    private Ranking ranking;

}
