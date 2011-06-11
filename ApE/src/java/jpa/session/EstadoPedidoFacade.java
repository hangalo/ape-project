/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.EstadoPedido;

/**
 *
 * @author verito
 */
@Stateless
public class EstadoPedidoFacade extends AbstractFacade<EstadoPedido> {
    @PersistenceContext(unitName = "ApEPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoPedidoFacade() {
        super(EstadoPedido.class);
    }
    
}
