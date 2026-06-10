package br.com.lavanderia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lavanderia.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
