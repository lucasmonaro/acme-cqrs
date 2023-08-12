package br.com.lmonaro.acme.microservicequery.domain.mapper;

import br.com.lmonaro.acme.microservicequery.application.dto.ProdutoResponseDTO;
import br.com.lmonaro.acme.microservicequery.domain.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoResponseDTO toProdutoDTO(Produto produto) {
        if (produto == null)
            return null;

        return ProdutoResponseDTO.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .descricao(produto.getDescricao())
                .preco(produto.getPreco())
                .build();
    }
}
