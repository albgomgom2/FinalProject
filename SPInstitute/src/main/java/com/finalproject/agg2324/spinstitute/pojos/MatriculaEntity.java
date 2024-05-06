package com.finalproject.agg2324.spinstitute.pojos;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Matricula", schema = "public", catalog = "VTInstitute")
public class MatriculaEntity {
    private String idMatricula;
    private String dni;
    private String idCurso;
    private Date fechaMatricula;
    private boolean repetidor;
    private AlunmosEntity Dni;
    private CursosEntity idcursos;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_Matricula", nullable = false, length = 10)
    public String getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(String idMatricula) {
        this.idMatricula = idMatricula;
    }


    @Basic
    @Column(name = "Dni", nullable = false, length = 9)
    public String getDni() {
        return dni;
    }

    @OneToOne(mappedBy = "dnis")
    @JoinColumn(name = "Dni", referencedColumnName = "Dni", nullable = false)
    public AlunmosEntity getDnis(){
        return Dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setDnis(AlunmosEntity dni){
        Dni = dni;
    }

    public void setDni(AlunmosEntity dni) {
        Dni = dni;
    }

    @Basic
    @Column(name = "Id_Curso", nullable = false, length = 10)
    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    @Basic
    @Column(name = "Fecha_Matricula", nullable = false)
    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    @Basic
    @Column(name = "Repetidor", nullable = false)
    public boolean isRepetidor() {
        return repetidor;
    }

    public void setRepetidor(boolean repetidor) {
        this.repetidor = repetidor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatriculaEntity that = (MatriculaEntity) o;
        return repetidor == that.repetidor && Objects.equals(idMatricula, that.idMatricula) && Objects.equals(dni, that.dni) && Objects.equals(idCurso, that.idCurso) && Objects.equals(fechaMatricula, that.fechaMatricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMatricula, dni, idCurso, fechaMatricula, repetidor);
    }

    @ManyToOne
    @JoinColumn(name = "Id_Curso", referencedColumnName = "Id_Curso", nullable = false)
    public CursosEntity getIdcursos() {
        return idcursos;
    }

    public void setIdcursos(CursosEntity idcursos) {
        this.idcursos = idcursos;
    }
}
