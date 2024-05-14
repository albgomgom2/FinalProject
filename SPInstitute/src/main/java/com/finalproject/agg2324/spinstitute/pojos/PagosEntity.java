package com.finalproject.agg2324.spinstitute.pojos;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "\"Pagos\"", schema = "public", catalog = "VTInstitute")
public class PagosEntity {

    private Integer idpago;

    private String cuenta;

    private BigInteger cantidad;

    private String operacion;

    private Integer idalumno;

    private StudentsEntity alumnos;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpago", nullable = false)
    public Integer getIdpago() {
        return idpago;
    }

    public void setIdpago(Integer idpago) {
        this.idpago = idpago;
    }

    @Basic
    @Column(name = "cuenta", nullable = false, length = 50)
    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    @Basic
    @Column(name = "cantidad", nullable = false, precision = 0)
    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    @Basic
    @Column(name = "\"Operacion\"", nullable = false, length = 20)
    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Basic
    @Column(name = "idalumno", nullable = false)
    public Integer getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagosEntity that = (PagosEntity) o;
        return Objects.equals(idpago, that.idpago) && Objects.equals(cuenta, that.cuenta) && Objects.equals(cantidad, that.cantidad) && Objects.equals(operacion, that.operacion) && Objects.equals(idalumno, that.idalumno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpago, cuenta, cantidad, operacion, idalumno);
    }

    @ManyToOne
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno", nullable = false, insertable = false,updatable = false)
    public StudentsEntity getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(StudentsEntity alumnos) {
        this.alumnos = alumnos;
    }
}
