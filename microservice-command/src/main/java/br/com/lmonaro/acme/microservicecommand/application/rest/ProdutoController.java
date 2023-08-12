package br.com.lmonaro.acme.microservicecommand.application.rest;


import br.com.lmonaro.acme.microservicecommand.application.dto.CriarProdutoDTO;
import br.com.lmonaro.acme.microservicecommand.domain.mapper.ProdutoMapper;
import br.com.lmonaro.acme.microservicecommand.domain.model.Produto;
import br.com.lmonaro.acme.microservicecommand.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/command/produto")
public class ProdutoController {

    private ProdutoMapper produtoMapper;

    private ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoMapper produtoMapper,
                             ProdutoService produtoService) {
        this.produtoMapper = produtoMapper;
        this.produtoService = produtoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void criarProduto(@RequestBody CriarProdutoDTO criarProdutoDTO) {
        Produto produto = produtoMapper.toProduto(criarProdutoDTO);
        produtoService.criar(produto);
    }
}
