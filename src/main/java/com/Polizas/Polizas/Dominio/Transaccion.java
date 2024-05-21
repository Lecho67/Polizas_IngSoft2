package com.Polizas.Polizas.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private double monto;
    private String moneda;
    private BigDecimal trm;

    private String horaTrm;


    public Transaccion() {
    }

    public Transaccion(Long id, double monto, String moneda) {
        this.id = id;
        this.monto = monto;
        this.moneda = moneda;
        this.trm = null;
        this.horaTrm = null;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public BigDecimal getTrm() {
        return trm;
    }

    public void setTrm(BigDecimal trm) {
        this.trm = trm;
    }

    public String getHoraTrm() {
        return horaTrm;
    }

    public void setHoraTrm(String horaTrm) {
        this.horaTrm = horaTrm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }


    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "Id=" + id +
                ", monto=" + monto +
                ", moneda='" + moneda + '\'' +
                ", trm=" + trm +
                ", horaTrm='" + horaTrm + '\'' +
                '}';
    }
}
