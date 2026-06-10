package br.com.lavanderia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lavanderia.model.entity.HistoricoEntrega;

public interface HistoricoEntregaRepository
        extends JpaRepository<HistoricoEntrega, Long> {

}