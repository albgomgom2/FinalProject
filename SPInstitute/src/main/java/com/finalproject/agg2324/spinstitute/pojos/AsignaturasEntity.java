package com.finalproject.agg2324.spinstitute.pojos;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Asignaturas", schema = "public", catalog = "VTInstitute")
public class AsignaturasEntity {
    private int idAsignatura;
    private String nombre;
    private int horas;
    private List<NotasEntity> notas;
    private List<CursosEntity> idcursos;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_asignaturas", nullable = false, length = 10)
    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
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
    @Column(name = "Horas", nullable = false, precision = 0)
    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturasEntity that = (AsignaturasEntity) o;
        return Objects.equals(idAsignatura, that.idAsignatura) && Objects.equals(nombre, that.nombre) && Objects.equals(horas, that.horas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsignatura, nombre, horas);
    }

    @OneToMany(mappedBy = "asignaturas")
    public List<NotasEntity> getNotas() {
        return notas;
    }

    public void setNotas(List<NotasEntity> notas) {
        this.notas = notas;
    }

    @ManyToMany(mappedBy = "idasignaturas")
    public List<CursosEntity> getIdcursos() {
        return idcursos;
    }

    public void setIdcursos(List<CursosEntity> idcursos) {
        this.idcursos = idcursos;
    }
}
