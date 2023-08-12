package br.com.lmonaro.acme.microservicequery.domain.service;

import br.com.lmonaro.acme.microservicequery.domain.model.Produto;
import br.com.lmonaro.acme.microservicequery.infrastructure.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findAllByNomeIsLikeIgnoreCase(nome);
    }
}
