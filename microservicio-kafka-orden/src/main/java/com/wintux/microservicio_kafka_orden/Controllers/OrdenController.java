package com.wintux.microservicio_kafka_orden.Controllers;

import com.wintux.microservicio_kafka_base.DTO.Orden;
import com.wintux.microservicio_kafka_base.DTO.OrdenEvento;
import com.wintux.microservicio_kafka_orden.Kafka.ProductorOrden;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1") // http://localhost:8091/api/v1
public class OrdenController {
    private ProductorOrden productorOrden;

    public OrdenController(ProductorOrden productorOrden) {
        this.productorOrden = productorOrden;
    }
    @PostMapping("/orden") // http://localhost:8091/api/v1/orden [POST]
    public String recibirOrden(@RequestBody Orden orden){
        orden.setOrdenId(UUID.randomUUID().toString());
        OrdenEvento ordenEvento = new OrdenEvento();
        ordenEvento.setMensaje("El estado de la orden está en pendiente");
        ordenEvento.setEstado("PENDIENTE");
        ordenEvento.setOrden(orden);
        productorOrden.enviarMensaje(ordenEvento);
        return "Orden publicada.";
    }
}
