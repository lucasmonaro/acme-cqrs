package br.com.lmonaro.acme.microservicesync.infrastructure.eventsourcing;

import br.com.lmonaro.acme.microservicesync.domain.service.ProdutoService;
import br.com.lmonaro.acme.microservicesync.infrastructure.eventsourcing.events.ProdutoCriadoEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaEventListener {

    private final String TOPIC_PRODUTO_CRIADO = "produto-criado";

    private ProdutoService produtoService;

    @Autowired
    public KafkaEventListener(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @KafkaListener(topics = TOPIC_PRODUTO_CRIADO)
    public void listen(ConsumerRecord<String, String> stringStringConsumerRecord) throws Exception {
        log.info("Sincronizando o tópico {}.", TOPIC_PRODUTO_CRIADO);

        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());

        ProdutoCriadoEvent produto = objectMapper.readValue(stringStringConsumerRecord.value(), ProdutoCriadoEvent.class);

        produtoService.sincronizarProduto(produto);
    }

//    @KafkaListener(topicPartitions = @TopicPartition(topic = TOPIC_PRODUTO_CRIADO,
//            partitionOffsets = {@PartitionOffset(partition = "0", initialOffset = "0")}))
//    public void reprocessar(ConsumerRecord<String, String> stringStringConsumerRecord) throws Exception {
//        log.info("Sincronizando o tópico {}.", TOPIC_PRODUTO_CRIADO);
//
//        ObjectMapper objectMapper = new ObjectMapper()
//                .registerModule(new JavaTimeModule());
//
//        ProdutoCriadoEvent produto = objectMapper.readValue(stringStringConsumerRecord.value(), ProdutoCriadoEvent.class);
//
//        produtoService.sincronizarProduto(produto);
//    }
}
