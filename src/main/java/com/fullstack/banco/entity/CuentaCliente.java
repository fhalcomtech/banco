package com.fullstack.banco.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "cuenta_cliente", schema = "banco")
@Component
public class CuentaCliente {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    cliente_id Integer not null,
    private Cliente cliente;

    cuenta_numero varchar(20) not null,
    private Cuenta cuenta;
    primary key (id)
}
