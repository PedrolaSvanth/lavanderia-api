package br.com.lavanderia.dto.entrega;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import br.com.lavanderia.model.enums.PeriodoEntrega;
import br.com.lavanderia.model.enums.StatusEntrega;

public record EntregaResponseDTO(

        Long id,

        Long clienteId,
        Long motoristaId,
        Long criadoPorId,

        String numeroOrcamento,
        String tipoServico,
        String descricao,
        String observacaoMotorista,

        PeriodoEntrega periodo,
        StatusEntrega status,

        Boolean pago,

        LocalDate dataAgendada,
        LocalTime horaAgendada,

        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
