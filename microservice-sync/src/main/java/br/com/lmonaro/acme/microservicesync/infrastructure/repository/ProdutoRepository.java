package br.com.lmonaro.acme.microservicesync.infrastructure.repository;

import br.com.lmonaro.acme.microservicesync.domain.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
}
