/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author verito
 */
@Entity
@Table(name = "permisos_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermisosRol.findAll", query = "SELECT p FROM PermisosRol p"),
    @NamedQuery(name = "PermisosRol.findByIdRol", query = "SELECT p FROM PermisosRol p WHERE p.permisosRolPK.idRol = :idRol"),
    @NamedQuery(name = "PermisosRol.findByIdModulo", query = "SELECT p FROM PermisosRol p WHERE p.permisosRolPK.idModulo = :idModulo"),
    @NamedQuery(name = "PermisosRol.findByPerC", query = "SELECT p FROM PermisosRol p WHERE p.perC = :perC"),
    @NamedQuery(name = "PermisosRol.findByPerR", query = "SELECT p FROM PermisosRol p WHERE p.perR = :perR"),
    @NamedQuery(name = "PermisosRol.findByPerU", query = "SELECT p FROM PermisosRol p WHERE p.perU = :perU"),
    @NamedQuery(name = "PermisosRol.findByPerD", query = "SELECT p FROM PermisosRol p WHERE p.perD = :perD")})
public class PermisosRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PermisosRolPK permisosRolPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_c")
    private boolean perC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_r")
    private boolean perR;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_u")
    private boolean perU;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_d")
    private boolean perD;
    @JoinColumn(name = "id_modulo", referencedColumnName = "id_modulo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Modulo modulo;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rol rol;

    public PermisosRol() {
    }

    public PermisosRol(PermisosRolPK permisosRolPK) {
        this.permisosRolPK = permisosRolPK;
    }

    public PermisosRol(PermisosRolPK permisosRolPK, boolean perC, boolean perR, boolean perU, boolean perD) {
        this.permisosRolPK = permisosRolPK;
        this.perC = perC;
        this.perR = perR;
        this.perU = perU;
        this.perD = perD;
    }

    public PermisosRol(int idRol, int idModulo) {
        this.permisosRolPK = new PermisosRolPK(idRol, idModulo);
    }

    public PermisosRolPK getPermisosRolPK() {
        return permisosRolPK;
    }

    public void setPermisosRolPK(PermisosRolPK permisosRolPK) {
        this.permisosRolPK = permisosRolPK;
    }

    public boolean getPerC() {
        return perC;
    }

    public void setPerC(boolean perC) {
        this.perC = perC;
    }

    public boolean getPerR() {
        return perR;
    }

    public void setPerR(boolean perR) {
        this.perR = perR;
    }

    public boolean getPerU() {
        return perU;
    }

    public void setPerU(boolean perU) {
        this.perU = perU;
    }

    public boolean getPerD() {
        return perD;
    }

    public void setPerD(boolean perD) {
        this.perD = perD;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permisosRolPK != null ? permisosRolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisosRol)) {
            return false;
        }
        PermisosRol other = (PermisosRol) object;
        if ((this.permisosRolPK == null && other.permisosRolPK != null) || (this.permisosRolPK != null && !this.permisosRolPK.equals(other.permisosRolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.PermisosRol[ permisosRolPK=" + permisosRolPK + " ]";
    }
    
}
