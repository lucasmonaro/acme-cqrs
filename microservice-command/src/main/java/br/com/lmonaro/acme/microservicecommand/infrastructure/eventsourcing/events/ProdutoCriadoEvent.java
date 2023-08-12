package br.com.lmonaro.acme.microservicecommand.infrastructure.eventsourcing.events;

import br.com.lmonaro.acme.microservicecommand.domain.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoCriadoEvent {
    private UUID id;
    private Produto produto;
}
