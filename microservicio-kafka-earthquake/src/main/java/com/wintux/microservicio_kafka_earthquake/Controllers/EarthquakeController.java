package com.wintux.microservicio_kafka_orden.Controllers;

import com.wintux.microservicio_kafka_base.DTO.Earthquake;
import com.wintux.microservicio_kafka_base.DTO.EarthquakeEvento;
import com.wintux.microservicio_kafka_orden.Kafka.ProductorEarthquake;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1") // http://localhost:3001/api/v1
public class EarthquakeController {
    
	@Autowired
    public EarthquakeController(EarthquakeService earthquakeService) {
        this.earthquakeService = earthquakeService;
    }


    @GetMapping("/earthquakes")
    public String earthquakes() {
        earthquakeService.fetchAndPublishEarthquakes();
        return "Datos de terremotos publicados en Kafka.";
    }
}
