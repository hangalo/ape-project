/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author verito
 */
@Entity
@Table(name = "precio_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrecioProducto.findAll", query = "SELECT p FROM PrecioProducto p"),
    @NamedQuery(name = "PrecioProducto.findByIdPrecioProducto", query = "SELECT p FROM PrecioProducto p WHERE p.idPrecioProducto = :idPrecioProducto"),
    @NamedQuery(name = "PrecioProducto.findByValor", query = "SELECT p FROM PrecioProducto p WHERE p.valor = :valor"),
    @NamedQuery(name = "PrecioProducto.findByFechaCreacion", query = "SELECT p FROM PrecioProducto p WHERE p.fechaCreacion = :fechaCreacion")})
public class PrecioProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_precio_producto")
    private Integer idPrecioProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private float valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public PrecioProducto() {
    }

    public PrecioProducto(Integer idPrecioProducto) {
        this.idPrecioProducto = idPrecioProducto;
    }

    public PrecioProducto(Integer idPrecioProducto, float valor, Date fechaCreacion) {
        this.idPrecioProducto = idPrecioProducto;
        this.valor = valor;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdPrecioProducto() {
        return idPrecioProducto;
    }

    public void setIdPrecioProducto(Integer idPrecioProducto) {
        this.idPrecioProducto = idPrecioProducto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrecioProducto != null ? idPrecioProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecioProducto)) {
            return false;
        }
        PrecioProducto other = (PrecioProducto) object;
        if ((this.idPrecioProducto == null && other.idPrecioProducto != null) || (this.idPrecioProducto != null && !this.idPrecioProducto.equals(other.idPrecioProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.PrecioProducto[ idPrecioProducto=" + idPrecioProducto + " ]";
    }
    
}
