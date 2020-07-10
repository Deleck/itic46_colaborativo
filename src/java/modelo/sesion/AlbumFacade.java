/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.sesion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.entidades.Album;
import modelo.entidades.Artista;

/**
 *
 * @author alberto
 */
@Stateless
public class AlbumFacade extends AbstractFacade<Album> {

    @PersistenceContext(unitName = "iti42_03PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlbumFacade() {
        super(Album.class);
    }
    
    public void borrarDeArtista(Artista art){
        Query query = em.createQuery("DELETE FROM Album a WHERE a.artistaid = :art ");
        query.setParameter("art", art);
        query.executeUpdate();
    }
}
