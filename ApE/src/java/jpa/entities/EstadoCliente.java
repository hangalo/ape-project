/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author verito
 */
@Entity
@Table(name = "estado_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCliente.findAll", query = "SELECT e FROM EstadoCliente e"),
    @NamedQuery(name = "EstadoCliente.findByIdEstadoCliente", query = "SELECT e FROM EstadoCliente e WHERE e.idEstadoCliente = :idEstadoCliente"),
    @NamedQuery(name = "EstadoCliente.findByDescripcion", query = "SELECT e FROM EstadoCliente e WHERE e.descripcion = :descripcion")})
public class EstadoCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "id_estado_cliente")
    private Short idEstadoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoCliente")
    private Collection<Cliente> clienteCollection;

    public EstadoCliente() {
    }

    public EstadoCliente(Short idEstadoCliente) {
        this.idEstadoCliente = idEstadoCliente;
    }

    public EstadoCliente(Short idEstadoCliente, String descripcion) {
        this.idEstadoCliente = idEstadoCliente;
        this.descripcion = descripcion;
    }

    public Short getIdEstadoCliente() {
        return idEstadoCliente;
    }

    public void setIdEstadoCliente(Short idEstadoCliente) {
        this.idEstadoCliente = idEstadoCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoCliente != null ? idEstadoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCliente)) {
            return false;
        }
        EstadoCliente other = (EstadoCliente) object;
        if ((this.idEstadoCliente == null && other.idEstadoCliente != null) || (this.idEstadoCliente != null && !this.idEstadoCliente.equals(other.idEstadoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "jpa.entities.EstadoCliente[ idEstadoCliente=" + idEstadoCliente + " ]";
        return descripcion;
    }
    
}
