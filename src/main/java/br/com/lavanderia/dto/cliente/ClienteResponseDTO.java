package br.com.lavanderia.dto.cliente;

import java.time.LocalDateTime;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String telefone,
        String cep,
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String estado,
        String complemento,
        String observacao,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
