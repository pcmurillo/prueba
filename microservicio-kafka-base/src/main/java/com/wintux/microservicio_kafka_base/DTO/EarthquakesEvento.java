package com.wintux.microservicio_kafka_base.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EarthquakesEvento {
    private String tipo;
    private Propiedades propiedades;


}
