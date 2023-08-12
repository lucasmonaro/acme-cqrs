package br.com.lmonaro.acme.microservicecommand.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produtos")
@Builder
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private String descricao;

    private Double preco;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

}
