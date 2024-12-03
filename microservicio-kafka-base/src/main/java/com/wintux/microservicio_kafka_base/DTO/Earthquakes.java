package com.wintux.microservicio_kafka_base.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Earthquakes {
    private String type;
    private Propiedades properties;
}
