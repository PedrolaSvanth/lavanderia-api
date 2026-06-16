package br.com.lavanderia.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lavanderia.dto.entrega.EntregaRequestDTO;
import br.com.lavanderia.dto.entrega.EntregaResponseDTO;
import br.com.lavanderia.service.EntregaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/entregas")
@RequiredArgsConstructor
@Validated
public class EntregaController {
    
    private final EntregaService entregaService;

    @PostMapping
    public ResponseEntity<EntregaResponseDTO> criar(
            @Valid @RequestBody EntregaRequestDTO dto) {

        EntregaResponseDTO entrega = entregaService.criar(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(entrega);
    }

    @GetMapping
    public ResponseEntity<List<EntregaResponseDTO>> listarTodos() {

        return ResponseEntity.ok(entregaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaResponseDTO> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(entregaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntregaResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody EntregaRequestDTO dto) {

        return ResponseEntity.ok(entregaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        entregaService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
