package br.com.lavanderia.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lavanderia.model.entity.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {

        List<Entrega> findByDataAgendada(LocalDate dataAgendada);
}