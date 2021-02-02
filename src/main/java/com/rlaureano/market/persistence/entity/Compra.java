package com.rlaureano.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "COMPRAS")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compras")
    private Integer idCompras;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;
    private String comentario;
    private String estado;
    @Column(name = "id_cliente")
    private String idCliente;

    @ManyToOne
    @JoinColumn(name = "id_cliente",insertable= false, updatable=false)
    private Cliente cliente;

    @OneToMany(mappedBy = "compra",cascade = {CascadeType.ALL})
    private List<ComprasProducto> productos;

}
