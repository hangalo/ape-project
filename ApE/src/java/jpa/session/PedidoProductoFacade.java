/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.PedidoProducto;

/**
 *
 * @author verito
 */
@Stateless
public class PedidoProductoFacade extends AbstractFacade<PedidoProducto> {
    @PersistenceContext(unitName = "ApEPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoProductoFacade() {
        super(PedidoProducto.class);
    }
    
}
