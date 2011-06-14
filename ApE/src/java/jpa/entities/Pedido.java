/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author verito
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "Pedido.findByFechaCreacion", query = "SELECT p FROM Pedido p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Pedido.findByFechaFinalizacion", query = "SELECT p FROM Pedido p WHERE p.fechaFinalizacion = :fechaFinalizacion"),
    @NamedQuery(name = "Pedido.findByValorTotal", query = "SELECT p FROM Pedido p WHERE p.valorTotal = :valorTotal"),
    @NamedQuery(name = "Pedido.findByDescripcion", query = "SELECT p FROM Pedido p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Pedido.findByDestNombres", query = "SELECT p FROM Pedido p WHERE p.destNombres = :destNombres"),
    @NamedQuery(name = "Pedido.findByDestApellidos", query = "SELECT p FROM Pedido p WHERE p.destApellidos = :destApellidos"),
    @NamedQuery(name = "Pedido.findByDestDireccion1", query = "SELECT p FROM Pedido p WHERE p.destDireccion1 = :destDireccion1"),
    @NamedQuery(name = "Pedido.findByDestDireccion2", query = "SELECT p FROM Pedido p WHERE p.destDireccion2 = :destDireccion2"),
    @NamedQuery(name = "Pedido.findByDestCiudad", query = "SELECT p FROM Pedido p WHERE p.destCiudad = :destCiudad"),
    @NamedQuery(name = "Pedido.findByDestCodPostal", query = "SELECT p FROM Pedido p WHERE p.destCodPostal = :destCodPostal")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "id_pedido")
    private Integer idPedido;
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_finalizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_total")
    private float valorTotal;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dest_nombres")
    private String destNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dest_apellidos")
    private String destApellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dest_direccion1")
    private String destDireccion1;
    @Size(max = 45)
    @Column(name = "dest_direccion2")
    private String destDireccion2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dest_ciudad")
    private String destCiudad;
    @Column(name = "dest_cod_postal")
    private Integer destCodPostal;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private PedidoProducto pedidoProducto;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_estado_pedido", referencedColumnName = "id_estado_pedido")
    @ManyToOne(optional = false)
    private EstadoPedido idEstadoPedido;
    @OneToMany
    private List<PedidoProducto> lProductos;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(Integer idPedido, Date fechaCreacion, float valorTotal, String destNombres, String destApellidos, String destDireccion1, String destCiudad, List<PedidoProducto> lProductos) {
        this.idPedido = idPedido;
        this.fechaCreacion = fechaCreacion;
        this.valorTotal = valorTotal;
        this.destNombres = destNombres;
        this.destApellidos = destApellidos;
        this.destDireccion1 = destDireccion1;
        this.destCiudad = destCiudad;
        this.lProductos = lProductos;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDestNombres() {
        return destNombres;
    }

    public void setDestNombres(String destNombres) {
        this.destNombres = destNombres;
    }

    public String getDestApellidos() {
        return destApellidos;
    }

    public void setDestApellidos(String destApellidos) {
        this.destApellidos = destApellidos;
    }

    public String getDestDireccion1() {
        return destDireccion1;
    }

    public void setDestDireccion1(String destDireccion1) {
        this.destDireccion1 = destDireccion1;
    }

    public String getDestDireccion2() {
        return destDireccion2;
    }

    public void setDestDireccion2(String destDireccion2) {
        this.destDireccion2 = destDireccion2;
    }

    public String getDestCiudad() {
        return destCiudad;
    }

    public void setDestCiudad(String destCiudad) {
        this.destCiudad = destCiudad;
    }

    public Integer getDestCodPostal() {
        return destCodPostal;
    }

    public void setDestCodPostal(Integer destCodPostal) {
        this.destCodPostal = destCodPostal;
    }

    public PedidoProducto getPedidoProducto() {
        return pedidoProducto;
    }

    public void setPedidoProducto(PedidoProducto pedidoProducto) {
        this.pedidoProducto = pedidoProducto;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public EstadoPedido getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(EstadoPedido idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
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
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "jpa.entities.Pedido[ idPedido=" + idPedido + " ]";
        return ""+idPedido;
    }

    /**
     * @return the lProductos
     */
    public List<PedidoProducto> getlProductos() {
        return lProductos;
    }

    /**
     * @param lProductos the lProductos to set
     */
    public void setlProductos(List<PedidoProducto> lProductos) {
        this.lProductos = lProductos;
    }
    
}
