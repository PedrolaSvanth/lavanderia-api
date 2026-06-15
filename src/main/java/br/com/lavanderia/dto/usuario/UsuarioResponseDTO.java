package br.com.lavanderia.dto.usuario;

import java.time.LocalDateTime;

public record UsuarioResponseDTO(

        Long id,
        String nome,
        String email,
        String telefone,
        String cargo,
        Boolean ativo,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}