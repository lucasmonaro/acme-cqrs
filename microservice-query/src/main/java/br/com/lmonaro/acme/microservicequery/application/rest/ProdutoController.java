package br.com.lmonaro.acme.microservicequery.application.rest;

import br.com.lmonaro.acme.microservicequery.application.dto.ProdutoResponseDTO;
import br.com.lmonaro.acme.microservicequery.domain.mapper.ProdutoMapper;
import br.com.lmonaro.acme.microservicequery.domain.model.Produto;
import br.com.lmonaro.acme.microservicequery.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query/produto")
public class ProdutoController {

    private ProdutoMapper produtoMapper;

    private ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoMapper produtoMapper,
                             ProdutoService produtoService) {
        this.produtoMapper = produtoMapper;
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> criarProduto(@RequestParam String nome) {
        List<Produto> produto = produtoService.buscarPorNome(nome);
        return ResponseEntity.ok(produto.stream()
                .map(produtoMapper::toProdutoDTO).
                toList());
    }
}
