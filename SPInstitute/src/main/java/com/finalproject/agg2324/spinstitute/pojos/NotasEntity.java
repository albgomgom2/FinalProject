package com.finalproject.agg2324.spinstitute.pojos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Notas", schema = "public", catalog = "VTInstitute")
public class NotasEntity {
    private int idNotas;
    private String dni;
    private int asignatura;
    private int nota1;
    private int nota2;
    private int nota3;
    private int notafinal;
    private boolean activo;
    private String estado;
    private AlumnosEntity dnis;
    private AsignaturasEntity asignaturas;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_notas", nullable = false)
    public int getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(int idNotas) {
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
    public int getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(int asignatura) {
        this.asignatura = asignatura;
    }

    @Basic
    @Column(name = "nota1")
    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    @Basic
    @Column(name = "nota2")
    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    @Basic
    @Column(name = "nota3")
    public int getNota3() {
        return nota3;
    }

    public void setNota3(int nota3) {
        this.nota3 = nota3;
    }

    @Basic
    @Column(name = "notafinal")
    public int getNotafinal() {
        return notafinal;
    }

    public void setNotafinal(int notafinal) {
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

    @Basic
    @Column(name = "estado", nullable = false, length = 30)
    public String getEstado(){return estado;}

    public void setEstado(String estado){this.estado = estado;}

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
    @JoinColumn(name = "Dni", referencedColumnName = "Dni", nullable = false, insertable = false, updatable = false)
    public AlumnosEntity getDnis() {
        return dnis;
    }

    public void setDnis(AlumnosEntity dnis) {
        this.dnis = dnis;
    }

    @ManyToOne
    @JoinColumn(name = "Asignatura", nullable = false, insertable = false, updatable = false, referencedColumnName = "id_asignaturas")
    public AsignaturasEntity getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(AsignaturasEntity asignaturas) {
        this.asignaturas = asignaturas;
    }
}
