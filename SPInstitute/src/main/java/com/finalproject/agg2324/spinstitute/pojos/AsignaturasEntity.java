package com.finalproject.agg2324.spinstitute.pojos;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "\"Asignaturas\"", schema = "public", catalog = "VTInstitute")
public class AsignaturasEntity {

    private Integer idAsignaturas;

    private String nombre;

    private BigInteger horas;

    private Set<NotasEntity> notas;

    private Set<CursosEntity> cursos;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_asignaturas", nullable = false)
    public Integer getIdAsignaturas() {
        return idAsignaturas;
    }

    public void setIdAsignaturas(Integer idAsignaturas) {
        this.idAsignaturas = idAsignaturas;
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
    @Column(name = "horas", nullable = false, precision = 0)
    public BigInteger getHoras() {
        return horas;
    }

    public void setHoras(BigInteger horas) {
        this.horas = horas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturasEntity that = (AsignaturasEntity) o;
        return Objects.equals(idAsignaturas, that.idAsignaturas) && Objects.equals(nombre, that.nombre) && Objects.equals(horas, that.horas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsignaturas, nombre, horas);
    }

    @OneToMany(mappedBy = "asignaturas")
    public Set<NotasEntity> getNotas() {
        return notas;
    }

    public void setNotas(Set<NotasEntity> notas) {
        this.notas = notas;
    }

    @ManyToMany
    @JoinTable(name = "\"Asignaturas_Cursos\"", catalog = "VTInstitute", schema = "public", joinColumns = @JoinColumn(name = "asignatura", referencedColumnName = "id_asignaturas", nullable = false), inverseJoinColumns = @JoinColumn(name = "idcurso", referencedColumnName = "id_curso", nullable = false))
    public Set<CursosEntity> getCursos() {
        return cursos;
    }

    public void setCursos(Set<CursosEntity> cursos) {
        this.cursos = cursos;
    }
}
