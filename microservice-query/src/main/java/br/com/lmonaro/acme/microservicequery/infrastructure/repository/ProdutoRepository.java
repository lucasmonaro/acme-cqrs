package br.com.lmonaro.acme.microservicequery.infrastructure.repository;

import br.com.lmonaro.acme.microservicequery.domain.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
    List<Produto> findAllByNomeIsLikeIgnoreCase(String nome);
}
