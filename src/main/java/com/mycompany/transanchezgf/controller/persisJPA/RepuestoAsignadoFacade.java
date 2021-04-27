
package com.mycompany.transanchezgf.controller.persisJPA;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.transanchezgf.persisJPA.RepuestoAsignado;

/**
 *
 * @author SAODRI
 */
@Stateless
public class RepuestoAsignadoFacade extends AbstractFacade<RepuestoAsignado> {

    @PersistenceContext(unitName = "com.mycompany_TransanchezGF_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepuestoAsignadoFacade() {
        super(RepuestoAsignado.class);
    }
    
}
