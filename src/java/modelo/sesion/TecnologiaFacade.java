/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.sesion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidades.Tecnologia;

/**
 *
 * @author alberto
 */
@Stateless
public class TecnologiaFacade extends AbstractFacade<Tecnologia> {

    @PersistenceContext(unitName = "iti42_03PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TecnologiaFacade() {
        super(Tecnologia.class);
    }
    
}
