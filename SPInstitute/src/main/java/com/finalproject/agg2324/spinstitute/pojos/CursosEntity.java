package com.finalproject.agg2324.spinstitute.pojos;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "\"Cursos\"", schema = "public", catalog = "VTInstitute")
public class CursosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_curso", nullable = false)
    private Integer idCurso;
    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "abreviatura", nullable = false, length = 10)
    private String abreviatura;
    @Basic
    @Column(name = "aula", nullable = false, length = 10)
    private String aula;
    @Basic
    @Column(name = "turno", nullable = false, precision = 0)
    private BigInteger turno;
    @OneToMany(mappedBy = "cursos")
    private Set<MatriculaEntity> matriculas;
    @ManyToMany
    @JoinTable(name = "Asignaturas_Cursos", catalog = "VTInstitute", schema = "public", joinColumns = @JoinColumn(name = "idcurso", referencedColumnName = "id_curso", nullable = false), inverseJoinColumns = @JoinColumn(name = "asignatura", referencedColumnName = "id_asignaturas", nullable = false))
    private Set<AsignaturasEntity> asignaturas;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_curso", nullable = false)
    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "abreviatura", nullable = false, length = 10)
    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Basic
    @Column(name = "aula", nullable = false, length = 10)
    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    @Basic
    @Column(name = "turno", nullable = false, precision = 0)
    public BigInteger getTurno() {
        return turno;
    }

    public void setTurno(BigInteger turno) {
        this.turno = turno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursosEntity that = (CursosEntity) o;
        return Objects.equals(idCurso, that.idCurso) && Objects.equals(nombre, that.nombre) && Objects.equals(abreviatura, that.abreviatura) && Objects.equals(aula, that.aula) && Objects.equals(turno, that.turno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, nombre, abreviatura, aula, turno);
    }

    @OneToMany(mappedBy = "cursos")
    public Set<MatriculaEntity> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Set<MatriculaEntity> matriculas) {
        this.matriculas = matriculas;
    }

    @ManyToMany(mappedBy = "cursos")
    public Set<AsignaturasEntity> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Set<AsignaturasEntity> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
