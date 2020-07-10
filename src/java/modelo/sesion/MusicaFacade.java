/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.sesion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidades.Musica;

/**
 *
 * @author alberto
 */
@Stateless
public class MusicaFacade extends AbstractFacade<Musica> {

    @PersistenceContext(unitName = "iti42_03PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MusicaFacade() {
        super(Musica.class);
    }
    
    public void borrarLogicamente(Musica m){
        m.setEstatus(Short.parseShort("0"));
        getEntityManager().merge(m);
    }    
}
