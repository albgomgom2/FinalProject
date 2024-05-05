package com.finalproject.agg2324.spinstitute.pojos;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "Notas", schema = "public", catalog = "VTInstitute")
public class NotasEntity {
    private String idNotas;
    private String dni;
    private String asignatura;
    private BigInteger nota1;
    private BigInteger nota2;
    private BigInteger nota3;
    private BigInteger notafinal;
    private boolean activo;
    private AlunmosEntity dnis;
    private AsignaturasEntity asignaturas;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_notas", nullable = false, length = 10)
    public String getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(String idNotas) {
        this.idNotas = idNotas;
    }

    @Basic
    @Column(name = "Dni", nullable = false, length = 9)
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "Asignatura", nullable = false, length = 10)
    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
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
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotasEntity that = (NotasEntity) o;
        return activo == that.activo && Objects.equals(idNotas, that.idNotas) && Objects.equals(dni, that.dni) && Objects.equals(asignatura, that.asignatura) && Objects.equals(nota1, that.nota1) && Objects.equals(nota2, that.nota2) && Objects.equals(nota3, that.nota3) && Objects.equals(notafinal, that.notafinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNotas, dni, asignatura, nota1, nota2, nota3, notafinal, activo);
    }

    @ManyToOne
    @JoinColumn(name = "Dni", referencedColumnName = "Dni", nullable = false)
    public AlunmosEntity getDnis() {
        return dnis;
    }

    public void setDnis(AlunmosEntity dnis) {
        this.dnis = dnis;
    }

    @ManyToOne
    @JoinColumn(name = "Asignatura", referencedColumnName = "Id_Asignatura", nullable = false)
    public AsignaturasEntity getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(AsignaturasEntity asignaturas) {
        this.asignaturas = asignaturas;
    }
}
