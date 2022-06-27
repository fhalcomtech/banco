package com.fullstack.banco.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta", schema = "banco")
@Component
public class Cuenta {
    @Id
    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "saldo", nullable = false, columnDefinition = "default = 0")
    private Double saldo;

    @Column(name = "estado", nullable = false, columnDefinition = "default = 'inactivo'")
    private String estado;

    public Cuenta() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
