package com.wintux.microservicio_kafka_base.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orden {
    private String ordenId;
    private String nombre;
    private int cantidad;
    private double precio;
}
