/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "producto_precio_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoPrecioStock.findAll", query = "SELECT p FROM ProductoPrecioStock p"),
    @NamedQuery(name = "ProductoPrecioStock.findByIdProducto", query = "SELECT p FROM ProductoPrecioStock p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "ProductoPrecioStock.findByNombre", query = "SELECT p FROM ProductoPrecioStock p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProductoPrecioStock.findByNombreLike", query = "SELECT p FROM ProductoPrecioStock p WHERE p.nombre LIKE :nombre"),
    @NamedQuery(name = "ProductoPrecioStock.findByValor", query = "SELECT p FROM ProductoPrecioStock p WHERE p.valor = :valor"),
    @NamedQuery(name = "ProductoPrecioStock.findByCantidad", query = "SELECT p FROM ProductoPrecioStock p WHERE p.cantidad = :cantidad")})
public class ProductoPrecioStock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    @Id
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @Column(name = "cantidad")
    private Integer cantidad;

    public ProductoPrecioStock() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
}
