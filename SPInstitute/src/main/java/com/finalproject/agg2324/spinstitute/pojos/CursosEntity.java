package com.finalproject.agg2324.spinstitute.pojos;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Cursos", schema = "public", catalog = "VTInstitute")
public class CursosEntity {
    private String idCurso;
    private String nombre;
    private String abreviatura;
    private String aula;
    private int nivel;
    private int turno;
    private List<MatriculaEntity> matriculas;
    private List<AsignaturasEntity> idasignaturas;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_Curso", nullable = false, length = 10)
    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    @Basic
    @Column(name = "Nombre", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Abreviatura", nullable = false, length = 10)
    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Basic
    @Column(name = "Aula", nullable = false, length = 10)
    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    @Basic
    @Column(name = "nivel", nullable = false, precision = 0)
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Basic
    @Column(name = "turno", nullable = false, precision = 0)
    public int getTurno(){return turno;}

    public void setTurno(int turno){this.turno = turno;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursosEntity that = (CursosEntity) o;
        return Objects.equals(idCurso, that.idCurso) && Objects.equals(nombre, that.nombre) && Objects.equals(abreviatura, that.abreviatura) && Objects.equals(aula, that.aula) && Objects.equals(nivel, that.nivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, nombre, abreviatura, aula, nivel);
    }

    @OneToMany(mappedBy = "idcursos")
    public List<MatriculaEntity> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<MatriculaEntity> matriculas) {
        this.matriculas = matriculas;
    }

    @ManyToMany
    @JoinTable(name = "Asignaturas_Cursos", catalog = "VTInstitute", schema = "public", joinColumns = @JoinColumn(name = "idcurso", referencedColumnName = "Id_Curso", nullable = false), inverseJoinColumns = @JoinColumn(name = "asignatura", referencedColumnName = "id_asignaturas", nullable = false))
    public List<AsignaturasEntity> getIdasignaturas() {
        return idasignaturas;
    }

    public void setIdasignaturas(List<AsignaturasEntity> idasignaturas) {
        this.idasignaturas = idasignaturas;
    }
}
