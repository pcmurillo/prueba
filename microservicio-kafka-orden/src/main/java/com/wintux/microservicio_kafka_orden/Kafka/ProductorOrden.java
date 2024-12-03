package com.wintux.microservicio_kafka_orden.Kafka;

import com.wintux.microservicio_kafka_base.DTO.OrdenEvento;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProductorOrden {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductorOrden.class);
    private NewTopic topic;
    private KafkaTemplate<String, OrdenEvento> kafkaTemplate;

    public ProductorOrden(NewTopic topic, KafkaTemplate<String, OrdenEvento> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }
    public void enviarMensaje(OrdenEvento evento){
        LOGGER.info(String.format("Evento publicado desde microservicio Orden: %s",evento));
        Message<OrdenEvento> mensaje = MessageBuilder
                .withPayload(evento)
                .setHeader(KafkaHeaders.TOPIC,topic.name())
                .build();
        kafkaTemplate.send(mensaje);
    }
}
