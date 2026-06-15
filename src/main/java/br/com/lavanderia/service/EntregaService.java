package br.com.lavanderia.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lavanderia.dto.entrega.EntregaRequestDTO;
import br.com.lavanderia.dto.entrega.EntregaResponseDTO;
import br.com.lavanderia.model.entity.Cliente;
import br.com.lavanderia.model.entity.Entrega;
import br.com.lavanderia.model.entity.Usuario;
import br.com.lavanderia.repository.ClienteRepository;
import br.com.lavanderia.repository.EntregaRepository;
import br.com.lavanderia.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntregaService {
    
    private final UsuarioRepository usuarioRepository;
    private final EntregaRepository entregaRepository;
    private final ClienteRepository clienteRepository;

    public EntregaResponseDTO criar(EntregaRequestDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.clienteId())
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        Usuario motorista = usuarioRepository.findById(dto.motoristaId())
            .orElseThrow(() -> new RuntimeException("Motorista não encontrado."));

        Usuario criadoPor = usuarioRepository.findById(dto.criadoPorId())
            .orElseThrow(() -> new RuntimeException("Usuário criador não encontrado."));

        Entrega entrega = new Entrega();

        entrega.setCliente(cliente);
        entrega.setMotorista(motorista);
        entrega.setCriadoPor(criadoPor);

        entrega.setNumeroOrcamento(dto.numeroOrcamento());
        entrega.setTipoServico(dto.tipoServico());
        entrega.setDescricao(dto.descricao());
        entrega.setObservacaoMotorista(dto.observacaoMotorista());

        entrega.setPeriodo(dto.periodo());
        entrega.setStatus(dto.status());
        entrega.setPago(dto.pago());

        entrega.setDataAgendada(dto.dataAgendada());
        entrega.setHoraAgendada(dto.horaAgendada());

        entrega.setCreatedAt(LocalDateTime.now());
        entrega.setUpdatedAt(LocalDateTime.now());

        Entrega salva = entregaRepository.save(entrega);

        return converterParaResponseDTO(salva);
    }

    public List<EntregaResponseDTO> listarTodos() {

        return entregaRepository.findAll()
                .stream()
                .map(this::converterParaResponseDTO)
                .toList();
    }

    public EntregaResponseDTO buscarPorId(Long id) {

        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada."));

        return converterParaResponseDTO(entrega);
    }

    public EntregaResponseDTO atualizar(Long id, EntregaRequestDTO dto) {

        Entrega entrega = entregaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Entrega não encontrada."));

        Cliente cliente = clienteRepository.findById(dto.clienteId())
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        Usuario motorista = usuarioRepository.findById(dto.motoristaId())
            .orElseThrow(() -> new RuntimeException("Motorista não encontrado."));

        Usuario criadoPor = usuarioRepository.findById(dto.criadoPorId())
            .orElseThrow(() -> new RuntimeException("Usuário criador não encontrado."));

        entrega.setCliente(cliente);
        entrega.setMotorista(motorista);
        entrega.setCriadoPor(criadoPor);

        entrega.setNumeroOrcamento(dto.numeroOrcamento());
        entrega.setTipoServico(dto.tipoServico());
        entrega.setDescricao(dto.descricao());
        entrega.setObservacaoMotorista(dto.observacaoMotorista());

        entrega.setPeriodo(dto.periodo());
        entrega.setStatus(dto.status());
        entrega.setPago(dto.pago());

        entrega.setDataAgendada(dto.dataAgendada());
        entrega.setHoraAgendada(dto.horaAgendada());

        entrega.setUpdatedAt(LocalDateTime.now());

        Entrega atualizada = entregaRepository.save(entrega);

        return converterParaResponseDTO(atualizada);
    }

    public void excluir(Long id) {

        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada."));

        entregaRepository.delete(entrega);
    }

    private EntregaResponseDTO converterParaResponseDTO(Entrega entrega) {
        return new EntregaResponseDTO(
            entrega.getId(),
            entrega.getCliente().getId(),
            entrega.getMotorista().getId(),
            entrega.getCriadoPor().getId(),
            entrega.getNumeroOrcamento(),
            entrega.getTipoServico(),
            entrega.getDescricao(),
            entrega.getObservacaoMotorista(),
            entrega.getPeriodo(),
            entrega.getStatus(),
            entrega.getPago(),
            entrega.getDataAgendada(),
            entrega.getHoraAgendada(),
            entrega.getCreatedAt(),
            entrega.getUpdatedAt()
        );

    }

}
