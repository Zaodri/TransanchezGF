
package com.mycompany.transanchezgf.controller.persisJPA;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.mycompany.transanchezgf.persisJPA.CredencialEmple;
import controllerAbstract.CredencialEmpleFacadeAbst;
/**
 *
 * @author SAODRI
 */
@Stateless
public class CredencialEmpleFacade extends AbstractFacade<CredencialEmple> implements CredencialEmpleFacadeAbst{

    @PersistenceContext(unitName = "com.mycompany_TransanchezGF_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


    @Override
    public CredencialEmple validarCredEmple(String strUsuario, String claveIn){
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query qt = em.createQuery("SELECT u FROM CredencialEmple u WHERE u.password = :p1 AND u.usuario = :p2");
            qt.setParameter("p1", claveIn);
            qt.setParameter("p2", strUsuario);
            List<CredencialEmple> listaCredencialEmple = qt.getResultList();
            
            if(listaCredencialEmple.isEmpty()){
                return null;
            }else{
                return listaCredencialEmple.get(0);
            }            
        } catch (Exception e) {
            return null;
        }
    }
    

    public CredencialEmpleFacade() {
        super(CredencialEmple.class);
    }
    
}
