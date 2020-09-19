package com.bolasaideas.springboot.app.models.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "factura_items")
public class ItemFactura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Long calcularImporte() {
        return cantidad.longValue();
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
