package com.finalproject.agg2324.spinstitute.pojos;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "\"Matricula\"", schema = "public", catalog = "VTInstitute")
public class MatriculaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_matricula", nullable = false)
    private Integer idMatricula;
    @Basic
    @Column(name = "repetidor", nullable = false)
    private Boolean repetidor;
    @Basic
    @Column(name = "estado", nullable = false, length = 30)
    private String estado;
    @Basic
    @Column(name = "fechamatricula", nullable = false)
    private Date fechamatricula;
    @Basic
    @Column(name = "idcurso", nullable = false)
    private Integer idcurso;
    @Basic
    @Column(name = "nivel", nullable = false)
    private Integer nivel;
    @Basic
    @Column(name = "turno", nullable = false, length = 10)
    private String turno;
    @Basic
    @Column(name = "idalumno", nullable = false)
    private Integer idalumno;
    @OneToOne(mappedBy = "matriculas")
    private StudentsEntity alumnos;
    @ManyToOne
    @JoinColumn(name = "idcurso", referencedColumnName = "id_curso", nullable = false)
    private CursosEntity cursos;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_matricula", nullable = false)
    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    @Basic
    @Column(name = "repetidor", nullable = false)
    public Boolean getRepetidor() {
        return repetidor;
    }

    public void setRepetidor(Boolean repetidor) {
        this.repetidor = repetidor;
    }

    @Basic
    @Column(name = "estado", nullable = false, length = 30)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "fechamatricula", nullable = false)
    public Date getFechamatricula() {
        return fechamatricula;
    }

    public void setFechamatricula(Date fechamatricula) {
        this.fechamatricula = fechamatricula;
    }

    @Basic
    @Column(name = "idcurso", nullable = false)
    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    @Basic
    @Column(name = "nivel", nullable = false)
    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    @Basic
    @Column(name = "turno", nullable = false, length = 10)
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Basic
    @Column(name = "idalumno", nullable = false)
    public Integer getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatriculaEntity that = (MatriculaEntity) o;
        return Objects.equals(idMatricula, that.idMatricula) && Objects.equals(repetidor, that.repetidor) && Objects.equals(estado, that.estado) && Objects.equals(fechamatricula, that.fechamatricula) && Objects.equals(idcurso, that.idcurso) && Objects.equals(nivel, that.nivel) && Objects.equals(turno, that.turno) && Objects.equals(idalumno, that.idalumno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMatricula, repetidor, estado, fechamatricula, idcurso, nivel, turno, idalumno);
    }

    @OneToOne
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno", nullable = false, insertable = false,updatable = false)
    public StudentsEntity getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(StudentsEntity alumnos) {
        this.alumnos = alumnos;
    }

    @ManyToOne
    @JoinColumn(name = "idcurso", referencedColumnName = "id_curso", nullable = false, insertable = false,updatable = false)
    public CursosEntity getCursos() {
        return cursos;
    }

    public void setCursos(CursosEntity cursos) {
        this.cursos = cursos;
    }
}
