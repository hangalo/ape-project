/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Usuario;

/**
 *
 * @author verito
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "ApEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public boolean UsuarioLogin(Usuario usuario){
        List lista = em.createNamedQuery("Usuario.findByLogin")
                .setParameter("nomUsuario", usuario.getNomUsuario())
                .setParameter("clave", usuario.getClave())
                .getResultList();
        if(lista.size() > 0)
            return true;
        return false;
    }
}
