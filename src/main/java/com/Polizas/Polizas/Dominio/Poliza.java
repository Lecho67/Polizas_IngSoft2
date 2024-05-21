package com.Polizas.Polizas.Dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Poliza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String descripcion;

    // revisar a que hace referencia la cobertura
    private String cobertura;
    @OneToMany(mappedBy = "poliza")
    @JsonIgnore
    private List<CompraPoliza> compraPolizas;

    public Poliza() {
    }

    public Poliza(Long id, String descripcion, String cobertura,List<CompraPoliza> compraPolizas) {
        this.id = id;
        this.descripcion = descripcion;
        this.cobertura = cobertura;
        this.compraPolizas = compraPolizas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public List<CompraPoliza> getCompraPolizas() {
        return compraPolizas;
    }

    public void setCompraPolizas(ArrayList<CompraPoliza> compraPolizas) {
        this.compraPolizas = compraPolizas;
    }
}
