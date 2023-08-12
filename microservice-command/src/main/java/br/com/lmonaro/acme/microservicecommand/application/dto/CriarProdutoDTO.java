package br.com.lmonaro.acme.microservicecommand.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarProdutoDTO {
    private String nome;
    private String descricao;
    private Double preco;

}
