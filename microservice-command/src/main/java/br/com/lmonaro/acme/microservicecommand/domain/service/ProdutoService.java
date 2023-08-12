package br.com.lmonaro.acme.microservicecommand.domain.service;

import br.com.lmonaro.acme.microservicecommand.domain.model.Produto;
import br.com.lmonaro.acme.microservicecommand.infrastructure.eventsourcing.ProdutoEventSourcing;
import br.com.lmonaro.acme.microservicecommand.infrastructure.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    private ProdutoEventSourcing produtoEventSourcing;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository,
                          ProdutoEventSourcing produtoEventSourcing) {
        this.produtoRepository = produtoRepository;
        this.produtoEventSourcing = produtoEventSourcing;
    }

    public void criar(Produto produto) {
        log.info("Criando um novo produto. :)");
        produto.setDataCriacao(LocalDateTime.now());
        produto.setDataAtualizacao(LocalDateTime.now());
        produtoRepository.save(produto);
        produtoEventSourcing.publicProdutoCriado(produto);
    }
}
