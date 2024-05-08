package com.finalproject.agg2324.spinstitute.pojos;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Matriculas", schema = "public", catalog = "VTInstitute")
public class MatriculaEntity {
    private int idMatricula;
    private String dni;
    private int idCurso;
    private Date fechaMatricula;
    private boolean repetidor;
    private String estado;
    private AlumnosEntity Dni;
    private CursosEntity idcursos;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_Matricula", nullable = false, length = 10)
    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }


    @Basic
    @Column(name = "dni", nullable = false, length = 9)
    public String getDni() {
        return dni;
    }

    @OneToOne(mappedBy = "dnis")
    @JoinColumn(name = "Dni", referencedColumnName = "Dni", nullable = false)
    public AlumnosEntity getDnis(){
        return Dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setDnis(AlumnosEntity dni){
        Dni = dni;
    }

    public void setDni(AlumnosEntity dni) {
        Dni = dni;
    }

    @Basic
    @Column(name = "idcurso", nullable = false, length = 10)
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Basic
    @Column(name = "fechamatricula", nullable = false)
    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    @Basic
    @Column(name = "repetidor", nullable = false)
    public boolean isRepetidor() {
        return repetidor;
    }

    public void setRepetidor(boolean repetidor) {
        this.repetidor = repetidor;
    }

    @Basic
    @Column(name = "estado", nullable = false, length = 30)
    public String getEstado(){return estado;}

    public void setEstado(String estado){this.estado = estado;}

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
    @JoinColumn(name = "idcurso", referencedColumnName = "Id_Curso", nullable = false, insertable = false, updatable = false)
    public CursosEntity getIdcursos() {
        return idcursos;
    }

    public void setIdcursos(CursosEntity idcursos) {
        this.idcursos = idcursos;
    }
}
