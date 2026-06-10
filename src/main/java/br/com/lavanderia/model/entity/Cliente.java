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
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "telefone")
    private String telefone;

    @NotBlank
    @Column(name = "cep")
    private String cep;

    @NotBlank
    @Column(name = "logradouro")
    private String logradouro;

    @NotBlank
    @Column(name = "numero")
    private String numero;

    @NotBlank
    @Column(name = "bairro")
    private String bairro;

    @NotBlank
    @Column(name = "cidade")
    private String cidade;

    @NotBlank
    @Column(name = "estado", columnDefinition = "CHAR(2)")
    private String estado;
    
    @NotBlank
    @Column(name = "complemento")
    private String complemento;

    @NotBlank
    @Column(name = "observacao")
    private String observacao;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}

