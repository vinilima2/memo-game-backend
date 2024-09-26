package br.com.memogame.game.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Setter @Getter public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    private long id=0;

    @Column(name = "nome", unique=true, nullable=false)
    @lombok.NonNull
    private String nome;

    @Column(name="email", nullable=false)
    @lombok.NonNull
    private String email;

    @Column(name="senha", nullable=false)
    @lombok.NonNull
    private String senha;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Ranking ranking;
}
