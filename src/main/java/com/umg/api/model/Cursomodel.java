package com.umg.api.model;

public class Cursomodel {

    private int id_curso;
    private String nombre;
    private int codigo;
    private String semestre;
    private int creditos;
    private String estado_curso; // "activo" o "inactivo"
    private Integer catedraticoCod; // referencia al id del catedratico
    // Constructor sin parámetros
    public Cursomodel() {
    }

    public Cursomodel(int id_curso, String nombre, int codigo, String semestre, int creditos, String estado_curso, int catedraticoCod) {
        this.id_curso = id_curso;
        this.nombre = nombre;
        this.codigo = codigo;
        this.semestre = semestre;
        this.creditos = creditos;
        this.estado_curso = estado_curso;
        this.catedraticoCod = catedraticoCod;
    }

    // Getters y Setters
    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getEstado_curso() {
        return estado_curso;
    }

    public void setEstado_curso(String estado_curso) {
        this.estado_curso = estado_curso;
    }

    public Integer getCatedraticoCod() {
        return catedraticoCod;
    }

    public void setCatedraticoCod(Integer catedraticoCod) {
        this.catedraticoCod = catedraticoCod;
    }

}