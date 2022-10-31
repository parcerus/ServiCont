package com.ServiCont.entities;

import javax.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "nit")
    private Integer nit;


    public Empresa(){ 
    }

    public Empresa(Long id, String nombre, String direccion, Integer telefono, Integer nit){
        this.id=id;
        this.nombre=nombre;
        this.direccion=direccion;
        this.telefono=telefono;
        this.nit=nit;
        
    }


    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono(){
        return telefono;
    }
    public void setTelefono(Integer telefono){
        this.telefono = telefono;
    }

    public Integer getNit(){
        return nit;
    }
    public void setNit(Integer nit){
        this.nit = nit;
    }


}
