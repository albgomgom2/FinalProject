package com.finalproject.agg2324.spinstitute.pojos;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Pagos", schema = "public", catalog = "VTInstitute")
public class PagosEntity {
    private int idPagos;
    private String dni;
    private String cuenta;
    private double cantidad;
    private String operacion;
    private AlumnosEntity dnis;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpago", nullable = false)
    public int getIdPagos() {return idPagos;}

    public void setIdPagos(int idPagos) {this.idPagos = idPagos;}

    @Basic
    @Column(name = "dni", nullable = false, length = 9)
    public String getDni() {return dni;}

    public void setDni(String dni) {this.dni = dni;}

    @Basic
    @Column(name = "cuenta", nullable = false, length = 1)
    public String getCuenta() {return cuenta;}

    public void setCuenta(String cuenta) {this.cuenta = cuenta;}

    @Basic
    @Column(name = "cantidad", nullable = false)
    public double getCantidad() {return cantidad;}

    public void setCantidad(double cantidad) {this.cantidad = cantidad;}

    @Basic
    @Column(name = "Operacion", nullable = false, length = 10)
    public String getOperacion() {return operacion;}

    public void setOperacion(String operacion) {this.operacion = operacion;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagosEntity that = (PagosEntity) o;
        return Objects.equals(idPagos, that.idPagos) && Objects.equals(dni, that.dni) && Objects.equals(cuenta, that.cuenta) && Objects.equals(operacion, that.operacion);
    }

    @Override
    public int hashCode() {return Objects.hash(idPagos, dni, cuenta, operacion);}

    @ManyToOne
    @JoinColumn(name = "Dni", nullable = false, insertable = false, updatable = false, referencedColumnName = "dni")
    public AlumnosEntity getAlumno() {return dnis;}

    public void setDnis(AlumnosEntity dnis) {
        this.dnis = dnis;
    }
}
