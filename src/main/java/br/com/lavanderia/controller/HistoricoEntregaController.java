package br.com.lavanderia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lavanderia.dto.historico.HistoricoResponseDTO;
import br.com.lavanderia.service.HistoricoEntregaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/historico")
@RequiredArgsConstructor
public class HistoricoEntregaController {
    
    private final HistoricoEntregaService service;

    @GetMapping
    public ResponseEntity<List<HistoricoResponseDTO>>
            listarTodos() {

        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoResponseDTO>
            buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
