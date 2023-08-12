package br.com.lmonaro.acme.microservicesync.domain.service;

import br.com.lmonaro.acme.microservicesync.domain.mapper.ProdutoMapper;
import br.com.lmonaro.acme.microservicesync.domain.model.Produto;
import br.com.lmonaro.acme.microservicesync.infrastructure.eventsourcing.events.ProdutoCriadoEvent;
import br.com.lmonaro.acme.microservicesync.infrastructure.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private ProdutoMapper produtoMapper;

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoMapper produtoMapper,
                          ProdutoRepository produtoRepository) {
        this.produtoMapper = produtoMapper;
        this.produtoRepository = produtoRepository;
    }

    public void sincronizarProduto(ProdutoCriadoEvent produtoCriadoEvent) {
        Produto produto = this.produtoMapper.toProduto(produtoCriadoEvent);
        produto.setFornecedor("Muralis");
        this.produtoRepository.save(produto);
    }
}
