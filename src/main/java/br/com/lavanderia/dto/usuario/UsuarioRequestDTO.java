package br.com.lavanderia.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(

        @NotBlank
        String nome,

        @NotBlank
        String email,

        @NotBlank
        String senhaHash,

        @NotBlank
        String telefone,

        @NotBlank
        String cargo,

        Boolean ativo
) {}