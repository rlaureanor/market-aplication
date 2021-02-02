package com.rlaureano.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer userId;
    private String nombre;
    @Column(name = "apellido")
    private String apellidos;
    private String password;
    private String estado;

}
