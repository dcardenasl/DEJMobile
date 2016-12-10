/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojos.Minutos;

/**
 *
 * @author Centro de Trabajo
 */
@Stateless
public class MinutosFacade extends AbstractFacade<Minutos> implements MinutosFacadeLocal {

    @PersistenceContext(unitName = "DEJMobile-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MinutosFacade() {
        super(Minutos.class);
    }
    
}
