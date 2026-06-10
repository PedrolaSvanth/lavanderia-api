package br.com.lavanderia.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "senha_hash")
    private String senhaHash;

    @NotBlank
    @Column(name = "telefone")
    private String telefone;

    @NotBlank
    @Column(name = "cargo")
    private String cargo;

    @Column(name = "ativo")
    private Boolean ativo;

    @NotNull
    @Column (name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;   
}