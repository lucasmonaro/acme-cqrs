package br.com.lmonaro.acme.microservicecommand.infrastructure.eventsourcing;

import br.com.lmonaro.acme.microservicecommand.domain.model.Produto;
import br.com.lmonaro.acme.microservicecommand.infrastructure.eventsourcing.events.ProdutoCriadoEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class ProdutoEventSourcing {
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String TOPIC_PRODUTO_CRIADO = "produto-criado";

    @Autowired
    public ProdutoEventSourcing(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public ProdutoCriadoEvent publicProdutoCriado(Produto produto) {
        try {
            ProdutoCriadoEvent produtoCriadoEvent = ProdutoCriadoEvent.builder()
                    .id(UUID.randomUUID())
                    .produto(produto)
                    .build();

            ObjectWriter objectWriter = new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .writer()
                    .withDefaultPrettyPrinter();

            String json = objectWriter.writeValueAsString(produtoCriadoEvent);
            kafkaTemplate.send(TOPIC_PRODUTO_CRIADO, json);

            return produtoCriadoEvent;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
