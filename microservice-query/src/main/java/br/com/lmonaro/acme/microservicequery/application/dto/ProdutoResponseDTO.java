package br.com.lmonaro.acme.microservicequery.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoResponseDTO {
    private String id;
    private String nome;
    private String descricao;
    private Double preco;
}
