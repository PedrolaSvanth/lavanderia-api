package br.com.lavanderia.dto.login;

public record LoginRequestDTO(
    String email,
    String senha
) {}