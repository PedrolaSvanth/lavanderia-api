package br.com.lavanderia.dto.entrega;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.lavanderia.model.enums.StatusEntrega;

public record AgendaEntregaDTO (
        
        Long id,

        String nomeCliente,
        String telefoneCliente,

        String enderecoCliente,

        String nomeMotorista,

        String numeroOrcamento,

        String descricao,
        String observacaoMotorista,

        Boolean pago,

        StatusEntrega status,

        LocalDate dataAgendada,
        LocalTime horaAgendada
) {}
