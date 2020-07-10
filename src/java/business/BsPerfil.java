package business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidades.Musica;
import modelo.entidades.Ocupacion;
import modelo.entidades.Tecnologia;
import modelo.entidades.Usuario;
import modelo.sesion.MusicaFacade;
import modelo.sesion.OcupacionFacade;
import modelo.sesion.TecnologiaFacade;
import modelo.sesion.UsuarioFacade;


@Stateless
public class BsPerfil {

    @EJB
    private UsuarioFacade usuarioF;
    @EJB
    private OcupacionFacade ocupacionF;
    @EJB
    private MusicaFacade musicaF;
    @EJB
    private TecnologiaFacade tecnologiaF;

    @PersistenceContext()
    private EntityManager em;

    public void edit(String txtId, String txtUsuario, String txtPassword,
            String txtIdTecnologias[], String txtGenero, String txtIdOcupacion,
            String txtOtraOcupacion, String txtIdMusica[], String txtComentarios) {

        //obtiene el entity del usuario
        Usuario u = usuarioF.find(Integer.parseInt(txtId));
        u.setUsuario(txtUsuario);

        //obtiene el entity del perfil del usuario
        u.getPerfilList().get(u.getPerfilList().size() - 1).setPassword(txtPassword);
        u.getPerfilList().get(u.getPerfilList().size() - 1).setGenero(txtGenero);
        u.getPerfilList().get(u.getPerfilList().size() - 1).setComentarios(txtComentarios);
        
        //obtiene la ocupación seleccionada
        Ocupacion o;
        if (txtIdOcupacion.equals("0")) {
            //si no existe la ocupación 
            //la agrega
            o = new Ocupacion();
            o.setOcupacion(txtOtraOcupacion);
            o.setEstatus(Short.parseShort("1"));
            ocupacionF.create(o);
        } else {
            //su existe la ocupación
            //la busca
            o = ocupacionF.find(Integer.parseInt(txtIdOcupacion));
        }
        u.getPerfilList().get(u.getPerfilList().size() - 1).setOcupacionId(o);
        
        //obtiene la música seleccionada
        if (txtIdMusica != null) {
            List<Musica> musicaList = new ArrayList<>();
            for (String idM : txtIdMusica) {
                Musica musica = musicaF.find(Integer.parseInt(idM));
                musicaList.add(musica);
            }
            u.getPerfilList().get(u.getPerfilList().size() - 1).setMusicaList(musicaList);
        }

        //obtiene la tecnología seleccionada
        List<Tecnologia> tecnologiaList = new ArrayList<>();
        for (String idT : txtIdTecnologias) {
            Tecnologia tec = tecnologiaF.find(Integer.parseInt(idT));
            tecnologiaList.add(tec);
        }
        u.getPerfilList().get(u.getPerfilList().size() - 1).setTecnologiaList(tecnologiaList);

        //modifica el usuario y sus relaciones 
        //(perfil, ocupación, musica-favorita, tecnología-internet)
        usuarioF.edit(u);
    }
}
