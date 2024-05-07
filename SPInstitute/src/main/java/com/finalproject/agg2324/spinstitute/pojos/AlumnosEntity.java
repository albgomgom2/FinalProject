package com.finalproject.agg2324.spinstitute.pojos;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Alumnos", schema = "public", catalog = "VTInstitute")
public class AlumnosEntity {
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;
    private String direccion;
    private String pais;
    private String localidad;
    private String ciudad;
    private boolean activo;
    private String telefono;
    private String email;
    private Date fechaNacimiento;
    private MatriculaEntity dnis;
    private String usuario;
    private String contraseña;
    private Set<NotasEntity> notas;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Dni", nullable = false, length = 9)
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "Nombre", nullable = false, length = 30)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Apellidos", nullable = false, length = 50)
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "Edad", nullable = true, precision = 0)
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Basic
    @Column(name = "Direccion", nullable = true, length = 100)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "Pais", nullable = false, length = 30)
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Basic
    @Column(name = "Localidad", nullable = false, length = 30)
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Basic
    @Column(name = "Ciudad", nullable = false, length = 30)
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Basic
    @Column(name = "Activo", nullable = false)
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Basic
    @Column(name = "Telefono", nullable = true, length = 9)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "FechaNacimiento", nullable = false)
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnosEntity that = (AlumnosEntity) o;
        return activo == that.activo && Objects.equals(dni, that.dni) && Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos) && Objects.equals(edad, that.edad) && Objects.equals(direccion, that.direccion) && Objects.equals(localidad, that.localidad) && Objects.equals(ciudad, that.ciudad) && Objects.equals(pais, that.pais) && Objects.equals(telefono, that.telefono) && Objects.equals(email, that.email) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(dni, nombre, apellidos, edad, direccion, localidad, ciudad, pais, activo, telefono, email, fechaNacimiento, usuario);
        result = 31 * result;
        return result;
    }

    @OneToOne
    @JoinColumn(name = "Dni", nullable = false, insertable = false, updatable = false, referencedColumnName = "dni")
    public MatriculaEntity getDnis() {
        return dnis;
    }

    public void setDnis(MatriculaEntity dnis) {
        this.dnis = dnis;
    }

    @OneToMany(mappedBy = "dnis")
    public Set<NotasEntity> getNotas() {
        return notas;
    }

    public void setNotas(Set<NotasEntity> notas) {
        this.notas = notas;
    }

    @Basic
    @Column(name = "usuario", nullable = false, length = 9)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "contraseña", nullable = false, length = 12)
    public String getContraseña(){return contraseña;}

    public void setContraseña(String contraseña){this.contraseña = contraseña;}
}
