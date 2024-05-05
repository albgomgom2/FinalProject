package com.finalproject.agg2324.spinstitute.pojos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Usuarios", schema = "public", catalog = "VTInstitute")
public class UsuariosEntity {
    private String usuario;
    private String contraseña;
    private String dni;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Usuario", nullable = false, length = 9)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "Contraseña", nullable = false, length = 9)
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Basic
    @Column(name = "Dni", nullable = false, length = 9)
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
        UsuariosEntity that = (UsuariosEntity) o;
        return Objects.equals(usuario, that.usuario) && Objects.equals(contraseña, that.contraseña) && Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, contraseña, dni);
    }
}
