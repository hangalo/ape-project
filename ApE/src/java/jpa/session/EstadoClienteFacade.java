/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.EstadoCliente;

/**
 *
 * @author verito
 */
@Stateless
public class EstadoClienteFacade extends AbstractFacade<EstadoCliente> {
    @PersistenceContext(unitName = "ApEPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoClienteFacade() {
        super(EstadoCliente.class);
    }
    
}
