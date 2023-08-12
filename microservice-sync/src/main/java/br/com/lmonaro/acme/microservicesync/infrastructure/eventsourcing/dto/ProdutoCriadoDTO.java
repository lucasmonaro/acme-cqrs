package br.com.lmonaro.acme.microservicesync.infrastructure.eventsourcing.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoCriadoDTO {

    private Long id;

    private String nome;

    private String descricao;

    private Double preco;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;
}
