package com.wintux.microservicio_kafka_earthquake.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EarthquakeService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String KAFKA_TOPIC = "earthquakes";

    @Autowired
    public EarthquakeService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void fetchAndPublishEarthquakes() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson";
        EarthquakeResponse response = restTemplate.getForObject(url, EarthquakeResponse.class);

        if (response != null && response.getFeatures() != null) {
            for (Earthquake feature : response.getFeatures()) {
                kafkaTemplate.send(KAFKA_TOPIC, feature.toString()); // Publicar en Kafka
            }
        }
    }
}