package br.com.lavanderia.dto.entrega;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.lavanderia.model.enums.PeriodoEntrega;
import br.com.lavanderia.model.enums.StatusEntrega;
import jakarta.validation.constraints.NotNull;

public record EntregaRequestDTO(

        @NotNull Long clienteId,
        @NotNull Long motoristaId,
        @NotNull Long criadoPorId,

        @NotNull String numeroOrcamento,
        @NotNull String tipoServico,
        @NotNull String descricao,
        @NotNull String observacaoMotorista,

        @NotNull PeriodoEntrega periodo,
        @NotNull StatusEntrega status,

        @NotNull Boolean pago,

        @NotNull LocalDate dataAgendada,
        @NotNull LocalTime horaAgendada
) {}
