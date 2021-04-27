/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.transanchezgf.JPAControllers;

import com.mycompany.transanchezgf.controller.persisJPA.AbstractFacade;
import com.mycompany.transanchezgf.persisJPA.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SAODRI
 */
@Stateless
public class ClienteJpaController extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "com.mycompany_TransanchezGF_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteJpaController() {
        super(Cliente.class);
    }
    
}