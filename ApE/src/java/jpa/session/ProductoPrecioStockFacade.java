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
    
    public List<ProductoPrecioStock> buscar(String pattern) {
        return em.createNamedQuery("Producto.findByNombreLike")
                .setParameter("nombre", pattern)
                .getResultList();
    }
    
}
