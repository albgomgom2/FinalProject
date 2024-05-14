package com.finalproject.agg2324.spinstitute.pojos;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "\"Students\"", schema = "public", catalog = "VTInstitute")
public class StudentsEntity {

    private String nombre;

    private String apellidos;

    private BigInteger edad;

    private String direccion;

    private String localidad;

    private String ciudad;

    private String pais;

    private Boolean activo;

    private String telefono;

    private String email;

    private Date date;

    private String usuario;

    private String contrasenya;

    private Integer idalumno;

    private String dni;

    private Set<MatriculaEntity> matriculas;

    private Set<PagosEntity> pagos;

    private Set<NotasEntity> notas;

    @Basic
    @Column(name = "nombre", nullable = false, length = 30)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellidos", nullable = false, length = 50)
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "edad", nullable = false, precision = 0)
    public BigInteger getEdad() {
        return edad;
    }

    public void setEdad(BigInteger edad) {
        this.edad = edad;
    }

    @Basic
    @Column(name = "direccion", nullable = false, length = 100)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "localidad", nullable = false, length = 30)
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Basic
    @Column(name = "ciudad", nullable = false, length = 30)
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Basic
    @Column(name = "pais", nullable = false, length = 30)
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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
    @Column(name = "telefono", nullable = false, length = 9)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "date_", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "usuario", nullable = false, length = 9)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "contrasenya", nullable = false, length = 100)
    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idalumno", nullable = false)
    public Integer getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    @Basic
    @Column(name = "dni", nullable = false, length = 9)
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsEntity that = (StudentsEntity) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos) && Objects.equals(edad, that.edad) && Objects.equals(direccion, that.direccion) && Objects.equals(localidad, that.localidad) && Objects.equals(ciudad, that.ciudad) && Objects.equals(pais, that.pais) && Objects.equals(activo, that.activo) && Objects.equals(telefono, that.telefono) && Objects.equals(email, that.email) && Objects.equals(date, that.date) && Objects.equals(usuario, that.usuario) && Objects.equals(contrasenya, that.contrasenya) && Objects.equals(idalumno, that.idalumno) && Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, edad, direccion, localidad, ciudad, pais, activo, telefono, email, date, usuario, contrasenya, idalumno, dni);
    }

    @OneToMany(mappedBy = "alumnos")
    public Set<MatriculaEntity> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Set<MatriculaEntity> matriculas) {
        this.matriculas = matriculas;
    }

    @OneToMany(mappedBy = "alumnos")
    public Set<PagosEntity> getPagos() {
        return pagos;
    }

    public void setPagos(Set<PagosEntity> pagos) {
        this.pagos = pagos;
    }

    @OneToMany(mappedBy = "alumnos")
    public Set<NotasEntity> getNotas() {
        return notas;
    }

    public void setNotas(Set<NotasEntity> notas) {
        this.notas = notas;
    }
}
