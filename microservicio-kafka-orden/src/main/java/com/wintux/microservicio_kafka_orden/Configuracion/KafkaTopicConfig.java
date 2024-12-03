package com.wintux.microservicio_kafka_orden.Configuracion;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Value("${spring.kafka.topic.name}")
    private String nombreTpc;
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(nombreTpc)
                .partitions(3)
                .build();
    }
}
