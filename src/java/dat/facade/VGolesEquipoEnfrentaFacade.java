/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.facade;

import dat.entity.VGolesEquipoEnfrenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Salcedo
 */
@Stateless
public class VGolesEquipoEnfrentaFacade extends AbstractFacade<VGolesEquipoEnfrenta> {

    @PersistenceContext(unitName = "eliminatoriasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VGolesEquipoEnfrentaFacade() {
        super(VGolesEquipoEnfrenta.class);
    }
    
}
