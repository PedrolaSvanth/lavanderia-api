package br.com.lavanderia.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lavanderia.dto.usuario.UsuarioRequestDTO;
import br.com.lavanderia.dto.usuario.UsuarioResponseDTO;
import br.com.lavanderia.model.entity.Usuario;
import br.com.lavanderia.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    
    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenhaHash(dto.senhaHash());
        usuario.setTelefone(dto.telefone());
        usuario.setCargo(dto.cargo());
        usuario.setAtivo(dto.ativo());

        usuario.setCreatedAt(LocalDateTime.now());
        usuario.setUpdatedAt(LocalDateTime.now());

        Usuario salvo = usuarioRepository.save(usuario);

        return converterParaResponseDTO(salvo);
    }
    
    public List<UsuarioResponseDTO> listarTodos() {

        return usuarioRepository.findAll()
                .stream()
                .map(this::converterParaResponseDTO)
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        return converterParaResponseDTO(usuario);
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenhaHash(dto.senhaHash());
        usuario.setTelefone(dto.telefone());
        usuario.setCargo(dto.cargo());
        usuario.setAtivo(dto.ativo());

        usuario.setUpdatedAt(LocalDateTime.now());

        Usuario salvo = usuarioRepository.save(usuario);

        return converterParaResponseDTO(salvo);
    }

    public void excluir(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        usuarioRepository.delete(usuario);
    }

    private UsuarioResponseDTO converterParaResponseDTO(Usuario usuario) {

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getCargo(),
                usuario.getAtivo(),
                usuario.getCreatedAt(),
                usuario.getUpdatedAt()
        );
    }

}
