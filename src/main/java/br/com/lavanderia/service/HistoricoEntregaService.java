package br.com.lavanderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lavanderia.dto.historico.HistoricoResponseDTO;
import br.com.lavanderia.model.entity.HistoricoEntrega;
import br.com.lavanderia.repository.HistoricoEntregaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistoricoEntregaService {
    
    private final HistoricoEntregaRepository repository;

     public List<HistoricoResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(this::converterParaResponseDTO)
                .toList();
    }

    public HistoricoResponseDTO buscarPorId(Long id) {

        HistoricoEntrega historico = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Histórico não encontrado."));

        return converterParaResponseDTO(historico);
    }

    private HistoricoResponseDTO converterParaResponseDTO(
            HistoricoEntrega historico) {

        return new HistoricoResponseDTO(
                historico.getId(),
                historico.getEntrega().getId(),
                historico.getUsuario().getId(),
                historico.getAcao(),
                historico.getDescricao(),
                historico.getCreatedAt()
        );
    }

}
