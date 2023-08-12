package br.com.lmonaro.acme.microservicesync.infrastructure.eventsourcing.events;

import br.com.lmonaro.acme.microservicesync.infrastructure.eventsourcing.dto.ProdutoCriadoDTO;
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
    private ProdutoCriadoDTO produto;
}
