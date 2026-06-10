package br.com.lavanderia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lavanderia.model.entity.Cliente;

public interface ClienteRepository
        extends JpaRepository<Cliente, Long> {

}