/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.transanchezgf.controller.persisJPA;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.transanchezgf.persisJPA.Cargo;
/**
 *
 * @author SAODRI
 */
@Stateless
public class CargoFacade extends AbstractFacade<Cargo> {

    @PersistenceContext(unitName = "com.mycompany_TransanchezGF_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CargoFacade() {
        super(Cargo.class);
    }
    
}
