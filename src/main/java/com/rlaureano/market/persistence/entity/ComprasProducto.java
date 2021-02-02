package com.rlaureano.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "COMPRAS_PRODUCTOS")
public class ComprasProducto {

    @EmbeddedId
    private ComprasProductoPK id;
    private Integer cantidad;
    private Double total;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_producto",insertable = false, updatable = false)
    private Producto producto;

    @ManyToOne
    @MapsId("idCompras")
    @JoinColumn(name = "id_compras",insertable = false,updatable = false)
    private Compra compra;
}
