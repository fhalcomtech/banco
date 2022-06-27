package com.fullstack.banco.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Table(name = "movimiento", schema = "banco")
@Component
public class Movimiento {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha")
     GregorianCalendar fecha;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "saldo")
    private Double saldo;

    @ManyToOne()

    Cuenta cuente;
}
