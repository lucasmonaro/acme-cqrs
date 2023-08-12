package br.com.lmonaro.acme.microservicecommand.domain.mapper;

import br.com.lmonaro.acme.microservicecommand.application.dto.CriarProdutoDTO;
import br.com.lmonaro.acme.microservicecommand.domain.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toProduto(CriarProdutoDTO criarProdutoDTO) {
        if (criarProdutoDTO == null)
            return null;

        return Produto.builder()
                .nome(criarProdutoDTO.getNome())
                .descricao(criarProdutoDTO.getDescricao())
                .preco(criarProdutoDTO.getPreco())
                .build();
    }
}
