package br.com.lavanderia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lavanderia.model.entity.Entrega;

public interface EntregaRepository
        extends JpaRepository<Entrega, Long> {

}