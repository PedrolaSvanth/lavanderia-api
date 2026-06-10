package br.com.lavanderia.dto.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClienteRequestDTO(
        @NotBlank String nome,
        @NotBlank @Size(min = 10, max = 15) String telefone,
        @NotBlank @Pattern(regexp = "\\d{5}-\\d{3}") String cep,
        @NotBlank String logradouro,
        @NotBlank String numero,
        @NotBlank String bairro,    
        @NotBlank String cidade,
        @NotBlank @Size(min = 2,max = 2) String estado,
        String complemento,
        String observacao
) {
}