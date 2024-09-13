package br.com.memogame.game.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Setter @Getter public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id=0;

    @Column(name = "nome", unique=true, nullable=false)
    private String nome;

    @Column(name="email", nullable=false)
    private String email;

    @Column(name="senha", nullable=false)
    private String senha;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Ranking ranking;

    public Usuario() {  }
    public Usuario(final String nome, final String email, final String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}
