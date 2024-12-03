package com.wintux.microservicio_kafka_base.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenEvento {
    private String mensaje;
    private String estado; // PENDIENTE, COMPRADO, CANCELADO
    private Orden orden;
}
