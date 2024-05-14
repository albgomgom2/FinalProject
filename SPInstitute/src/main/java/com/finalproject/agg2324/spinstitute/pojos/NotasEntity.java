package com.finalproject.agg2324.spinstitute.pojos;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "\"Notas\"", schema = "public", catalog = "VTInstitute")
public class NotasEntity {

    private Integer idNotas;

    private BigInteger nota1;

    private BigInteger nota2;

    private BigInteger nota3;

    private BigInteger notafinal;

    private Boolean activo;

    private String estado;

    private Integer asignatura;

    private Integer idalumno;

    private StudentsEntity alumnos;

    private AsignaturasEntity asignaturas;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_notas", nullable = false)
    public Integer getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(Integer idNotas) {
        this.idNotas = idNotas;
    }

    @Basic
    @Column(name = "nota1", nullable = true, precision = 0)
    public BigInteger getNota1() {
        return nota1;
    }

    public void setNota1(BigInteger nota1) {
        this.nota1 = nota1;
    }

    @Basic
    @Column(name = "nota2", nullable = true, precision = 0)
    public BigInteger getNota2() {
        return nota2;
    }

    public void setNota2(BigInteger nota2) {
        this.nota2 = nota2;
    }

    @Basic
    @Column(name = "nota3", nullable = true, precision = 0)
    public BigInteger getNota3() {
        return nota3;
    }

    public void setNota3(BigInteger nota3) {
        this.nota3 = nota3;
    }

    @Basic
    @Column(name = "notafinal", nullable = true, precision = 0)
    public BigInteger getNotafinal() {
        return notafinal;
    }

    public void setNotafinal(BigInteger notafinal) {
        this.notafinal = notafinal;
    }

    @Basic
    @Column(name = "activo", nullable = false)
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
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
    @Column(name = "asignatura", nullable = false)
    public Integer getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Integer asignatura) {
        this.asignatura = asignatura;
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
        NotasEntity that = (NotasEntity) o;
        return Objects.equals(idNotas, that.idNotas) && Objects.equals(nota1, that.nota1) && Objects.equals(nota2, that.nota2) && Objects.equals(nota3, that.nota3) && Objects.equals(notafinal, that.notafinal) && Objects.equals(activo, that.activo) && Objects.equals(estado, that.estado) && Objects.equals(asignatura, that.asignatura) && Objects.equals(idalumno, that.idalumno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNotas, nota1, nota2, nota3, notafinal, activo, estado, asignatura, idalumno);
    }

    @ManyToOne
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno", nullable = false, insertable = false,updatable = false)
    public StudentsEntity getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(StudentsEntity alumnos) {
        this.alumnos = alumnos;
    }

    @ManyToOne
    @JoinColumn(name = "asignatura", referencedColumnName = "id_asignaturas", nullable = false, insertable = false,updatable = false)
    public AsignaturasEntity getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(AsignaturasEntity asignaturas) {
        this.asignaturas = asignaturas;
    }
}
