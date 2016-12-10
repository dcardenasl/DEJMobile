/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojos.Cuota;

/**
 *
 * @author Centro de Trabajo
 */
@Stateless
public class CuotaFacade extends AbstractFacade<Cuota> implements CuotaFacadeLocal {

    @PersistenceContext(unitName = "DEJMobile-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuotaFacade() {
        super(Cuota.class);
    }
    
}
