package com.rlaureano.market.persistence.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Setter
@Getter
@Embeddable
public class ComprasProductoPK implements Serializable {

    @Column(name = "id_compras")
    private Integer idCompras;
    @Column(name = "id_producto")
    private Integer idProducto;

}
