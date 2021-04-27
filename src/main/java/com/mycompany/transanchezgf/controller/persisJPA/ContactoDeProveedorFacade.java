
package com.mycompany.transanchezgf.controller.persisJPA;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.transanchezgf.persisJPA.ContactoDeProveedor;

/**
 *
 * @author SAODRI
 */
@Stateless
public class ContactoDeProveedorFacade extends AbstractFacade<ContactoDeProveedor> {

    @PersistenceContext(unitName = "com.mycompany_TransanchezGF_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactoDeProveedorFacade() {
        super(ContactoDeProveedor.class);
    }
    
}
