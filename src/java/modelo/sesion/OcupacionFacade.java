/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.sesion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidades.Ocupacion;

/**
 *
 * @author alberto
 */
@Stateless
public class OcupacionFacade extends AbstractFacade<Ocupacion> {

    @PersistenceContext(unitName = "iti42_03PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OcupacionFacade() {
        super(Ocupacion.class);
    }
    
}
