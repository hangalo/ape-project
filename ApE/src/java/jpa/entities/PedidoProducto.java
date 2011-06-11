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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author verito
 */
@Entity
@Table(name = "pedido_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoProducto.findAll", query = "SELECT p FROM PedidoProducto p"),
    @NamedQuery(name = "PedidoProducto.findByIdPedido", query = "SELECT p FROM PedidoProducto p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "PedidoProducto.findByCantidad", query = "SELECT p FROM PedidoProducto p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "PedidoProducto.findByValorUnitario", query = "SELECT p FROM PedidoProducto p WHERE p.valorUnitario = :valorUnitario")})
public class PedidoProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_unitario")
    private float valorUnitario;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto idProducto;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pedido pedido;

    public PedidoProducto() {
    }

    public PedidoProducto(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public PedidoProducto(Integer idPedido, int cantidad, float valorUnitario) {
        this.idPedido = idPedido;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoProducto)) {
            return false;
        }
        PedidoProducto other = (PedidoProducto) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.PedidoProducto[ idPedido=" + idPedido + " ]";
    }
    
}
