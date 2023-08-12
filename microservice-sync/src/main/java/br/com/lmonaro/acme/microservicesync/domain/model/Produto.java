package br.com.lmonaro.acme.microservicesync.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
public class Produto {
    @Id
    @JsonIgnore
    private String id;

    private String nome;

    private String descricao;

    private Double preco;

    private String fornecedor;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;
}
