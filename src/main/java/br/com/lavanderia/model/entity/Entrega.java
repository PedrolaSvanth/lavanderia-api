package br.com.lavanderia.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.lavanderia.model.enums.PeriodoEntrega;
import br.com.lavanderia.model.enums.StatusEntrega;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "entregas")   
public class Entrega {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Usuario motorista;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Usuario criadoPor;

    @NotBlank
    @Column(name = "numero_orcamento")
    private String numeroOrcamento;

    @NotBlank
    @Column(name = "tipo_servico")
    private String tipoServico;

    @NotBlank
    @Column(name = "descricao")
    private String descricao;

    @NotBlank
    @Column(name = "observacao_motorista")
    private String observacaoMotorista;

    @Enumerated(EnumType.STRING)
    private PeriodoEntrega periodo;

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    @Column(name = "pago")
    private Boolean pago;

    @NotNull
    @Column(name = "data_agendada")
    private LocalDate dataAgendada;

    @NotNull
    @Column(name = "hora_agendada")
    private LocalTime horaAgendada;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @OneToMany(mappedBy = "entrega")
    private List<HistoricoEntrega> historicos;
}