
package com.umg.api.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class Asignacionmodel {
    private Integer studentID;
    private Integer courseID;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaInscripcion;
    private String estado;

    
    public Asignacionmodel(){    
    }
    
        public Asignacionmodel(Integer student, Integer curso, String estado, LocalDate fecha) {
        this.studentID = student;
        this.courseID = curso;
        this.estado = estado;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    // Método toString para debugging
    @Override
    public String toString() {
        return "Asignacionmodel{" +
                "studentID =" + studentID +
                ", ourseID ='" + courseID + '\'' +
                ", fechaInscripcion='" + fechaInscripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
    
}
