package br.com.lavanderia.dto.cliente;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String telefone,
        String cep,
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String estado,
        String complemento,
        String observacao
) {
}
