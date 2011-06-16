/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ProductoPrecioStock;

/**
 *
 * @author carlos
 */
@Stateless
public class ProductoPrecioStockFacade extends AbstractFacade<ProductoPrecioStock> {
    @PersistenceContext(unitName = "ApEPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoPrecioStockFacade() {
        super(ProductoPrecioStock.class);
    }
    
    public List<ProductoPrecioStock> buscar(int[] range, String pattern) {
        javax.persistence.Query q = getEntityManager().createNamedQuery("ProductoPrecioStock.findByNombreLike")
                .setParameter("nombre", "%"+pattern+"%");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
    
}
