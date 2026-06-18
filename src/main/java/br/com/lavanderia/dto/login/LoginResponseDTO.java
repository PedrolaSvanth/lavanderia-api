package br.com.lavanderia.dto.login;

public record LoginResponseDTO(
    Long id,
    String nome,
    String email,
    String cargo
) {}
