package com.rlaureano.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    private String idCliente;
    private String nombre;
    private String apellido;
    private Long celular;
    private String direccion;
    @Column(name = "correo_electronico")
    private String correoElectronico;

    @OneToMany(mappedBy ="cliente")
    private List<Compra> compras;

}
