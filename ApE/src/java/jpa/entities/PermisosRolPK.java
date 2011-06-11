/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author verito
 */
@Embeddable
public class PermisosRolPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rol")
    private int idRol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_modulo")
    private int idModulo;

    public PermisosRolPK() {
    }

    public PermisosRolPK(int idRol, int idModulo) {
        this.idRol = idRol;
        this.idModulo = idModulo;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRol;
        hash += (int) idModulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisosRolPK)) {
            return false;
        }
        PermisosRolPK other = (PermisosRolPK) object;
        if (this.idRol != other.idRol) {
            return false;
        }
        if (this.idModulo != other.idModulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.PermisosRolPK[ idRol=" + idRol + ", idModulo=" + idModulo + " ]";
    }
    
}
