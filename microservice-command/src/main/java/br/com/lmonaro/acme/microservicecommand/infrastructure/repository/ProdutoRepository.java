package br.com.lmonaro.acme.microservicecommand.infrastructure.repository;

import br.com.lmonaro.acme.microservicecommand.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
