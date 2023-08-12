package br.com.lmonaro.acme.microservicesync.domain.mapper;

import br.com.lmonaro.acme.microservicesync.domain.model.Produto;
import br.com.lmonaro.acme.microservicesync.infrastructure.eventsourcing.events.ProdutoCriadoEvent;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {
    public Produto toProduto(ProdutoCriadoEvent produtoCriadoEvent) {
        if (produtoCriadoEvent == null) return null;

        return Produto.builder()
                .nome(produtoCriadoEvent.getProduto().getNome())
                .descricao(produtoCriadoEvent.getProduto().getDescricao())
                .preco(produtoCriadoEvent.getProduto().getPreco())
                .dataAtualizacao(produtoCriadoEvent.getProduto().getDataAtualizacao())
                .dataCriacao(produtoCriadoEvent.getProduto().getDataCriacao())
                .build();
    }
}
