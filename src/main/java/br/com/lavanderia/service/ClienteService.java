package br.com.lavanderia.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lavanderia.dto.cliente.ClienteRequestDTO;
import br.com.lavanderia.dto.cliente.ClienteResponseDTO;
import br.com.lavanderia.model.entity.Cliente;
import br.com.lavanderia.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    
    private final ClienteRepository clienteRepository;

    public ClienteResponseDTO criar(ClienteRequestDTO dto) {

        Cliente cliente = new Cliente();

        cliente.setNome(dto.nome());
        cliente.setTelefone(dto.telefone());
        cliente.setCep(dto.cep());
        cliente.setLogradouro(dto.logradouro());
        cliente.setNumero(dto.numero());
        cliente.setBairro(dto.bairro());
        cliente.setCidade(dto.cidade());
        cliente.setEstado(dto.estado());
        cliente.setComplemento(dto.complemento());
        cliente.setObservacao(dto.observacao());

        cliente.setCreatedAt(LocalDateTime.now());
        cliente.setUpdatedAt(LocalDateTime.now());

        Cliente salvo = clienteRepository.save(cliente);

        return converterParaResponseDTO(salvo);
    }

    public List<ClienteResponseDTO> listarTodos() {

        return clienteRepository.findAll()
                .stream()
                .map(this::converterParaResponseDTO)
                .toList();
    }

    public ClienteResponseDTO buscarPorId(Long id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        return converterParaResponseDTO(cliente);
    }

    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        cliente.setNome(dto.nome());
        cliente.setTelefone(dto.telefone());
        cliente.setCep(dto.cep());
        cliente.setLogradouro(dto.logradouro());
        cliente.setNumero(dto.numero());
        cliente.setBairro(dto.bairro());
        cliente.setCidade(dto.cidade());
        cliente.setEstado(dto.estado());
        cliente.setComplemento(dto.complemento());
        cliente.setObservacao(dto.observacao());

        cliente.setUpdatedAt(LocalDateTime.now());

        Cliente atualizado = clienteRepository.save(cliente);

        return converterParaResponseDTO(atualizado);
    }

    public void excluir(Long id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        clienteRepository.delete(cliente);
    }

    private ClienteResponseDTO converterParaResponseDTO(Cliente cliente) {

        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getCep(),
                cliente.getLogradouro(),
                cliente.getNumero(),
                cliente.getBairro(),
                cliente.getCidade(),
                cliente.getEstado(),
                cliente.getComplemento(),
                cliente.getObservacao(),
                cliente.getCreatedAt(),
                cliente.getUpdatedAt()
        );
    }
}
