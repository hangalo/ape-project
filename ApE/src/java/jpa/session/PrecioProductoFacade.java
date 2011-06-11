/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.PrecioProducto;

/**
 *
 * @author verito
 */
@Stateless
public class PrecioProductoFacade extends AbstractFacade<PrecioProducto> {
    @PersistenceContext(unitName = "ApEPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PrecioProductoFacade() {
        super(PrecioProducto.class);
    }
    
}
