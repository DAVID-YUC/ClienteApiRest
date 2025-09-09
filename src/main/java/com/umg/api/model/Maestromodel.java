package com.umg.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class Maestromodel {
    private Integer id_catedratico;
    private String nombre;
    private String apellido;
    private String email;
    private String especialidad;
    private String telefono;
    private String estado;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fecha_nacimiento;
    
    private LocalDate fecha_ingreso;

    // Constructor vacío
    public Maestromodel() {
    }

    // Constructor con parámetros
    public Maestromodel(String nombre, String apellido, String email, String especialidad, 
                       String telefono, String estado, LocalDate fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.estado = estado;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    // Getters y Setters
    public Integer getId_catedratico() {
        return id_catedratico;
    }

    public void setId_catedratico(Integer id_catedratico) {
        this.id_catedratico = id_catedratico;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    // Método toString para debugging
    @Override
    public String toString() {
        return "Maestromodel{" +
                "id_catedratico=" + id_catedratico +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", estado='" + estado + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", fecha_ingreso=" + fecha_ingreso +
                '}';
    }
}