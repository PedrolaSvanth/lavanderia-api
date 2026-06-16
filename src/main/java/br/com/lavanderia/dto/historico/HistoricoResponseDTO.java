package br.com.lavanderia.dto.historico;

import java.time.LocalDateTime;

public record HistoricoResponseDTO(
    Long id,
    Long entregaId,
    Long usuarioId,

    String acao,
    String descricao,

    LocalDateTime createdAt
){}