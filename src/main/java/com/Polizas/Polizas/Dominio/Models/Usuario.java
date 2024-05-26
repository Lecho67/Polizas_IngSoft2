package com.Polizas.Polizas.Dominio.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<CompraPoliza> compraPolizas;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String apellido, String email, String contraseña,List<CompraPoliza> compraPolizas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
        this.compraPolizas = compraPolizas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<CompraPoliza> getCompraPolizas() {
        return compraPolizas;
    }

    public void setCompraPolizas(ArrayList<CompraPoliza> compraPolizas) {
        this.compraPolizas = compraPolizas;
    }


}
