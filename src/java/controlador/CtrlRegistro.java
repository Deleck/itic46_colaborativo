/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.entidades.Musica;
import modelo.entidades.Ocupacion;
import modelo.entidades.Perfil;
import modelo.entidades.Tecnologia;
import modelo.entidades.Usuario;
import modelo.sesion.MusicaFacade;
import modelo.sesion.OcupacionFacade;
import modelo.sesion.TecnologiaFacade;
import modelo.sesion.UsuarioFacade;


/**
 *
 * @author alberto
 */
@WebServlet(name = "CtrlRegistro", urlPatterns = {"/registro"})
public class CtrlRegistro extends HttpServlet {

    @EJB
    private UsuarioFacade usuarioF;
    @EJB
    private MusicaFacade musicaF;
    @EJB
    private OcupacionFacade ocupacionF;
    @EJB
    private TecnologiaFacade tecnologiaF;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //obtiene catálogos para mostrarlos en el formulario
        List<Musica> listaMusica = musicaF.findAll();
        List<Ocupacion> listaOcupacion = ocupacionF.findAll();
        List<Tecnologia> listaTecnologia = tecnologiaF.findAll();
        request.setAttribute("listaMusica", listaMusica);
        request.setAttribute("listaOcupacion", listaOcupacion);
        request.setAttribute("listaTecnologia", listaTecnologia);
        request.setAttribute("titulo", "Registro de Perfil");
        request.setAttribute("action", "registro");
        request.getRequestDispatcher("/WEB-INF/registroFrm.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        //obtiene los datos del formulario
        String txtUsuario = request.getParameter("usuario");
        String txtPassword = request.getParameter("password");
        String txtIdTecnologias[] = request.getParameterValues("tecnologia");
        String txtGenero = request.getParameter("genero");
        String txtIdOcupacion = request.getParameter("ocupacion");
        String txtIdMusica[] = request.getParameterValues("musica");
        String txtComentarios = request.getParameter("comentarios");

        //crea el entity del usuario
        Usuario u = new Usuario();
        u.setUsuario(txtUsuario);
        u.setEstatus(Short.parseShort("1"));

        List<Perfil> listaPerfil = new ArrayList<>();
        
        //crea el entity del perfil del usuario
        Perfil p = new Perfil();
        p.setPassword(txtPassword);
        p.setGenero(txtGenero);
        p.setComentarios(txtComentarios);
        p.setUsuarioId(u);
        
        //obtiene la ocupación seleccionada
        p.setOcupacionId(ocupacionF.find(Integer.parseInt(txtIdOcupacion)));

        //obtiene la música seleccionada
        if (txtIdMusica != null) {
            List<Musica> musicaList = new ArrayList<>();
            for (String id : txtIdMusica) {
                Musica musica = musicaF.find(Integer.parseInt(id));
                musicaList.add(musica);
            }
            p.setMusicaList(musicaList);
        }

        //obtiene la tecnología seleccionada
        List<Tecnologia> tecnologiaList = new ArrayList<>();
        for (String id : txtIdTecnologias) {
            Tecnologia tec = tecnologiaF.find(Integer.parseInt(id));
            tecnologiaList.add(tec);
        }
        p.setTecnologiaList(tecnologiaList);
        
        //le pasa el perfil al usuario
        listaPerfil.add(p);
        u.setPerfilList(listaPerfil);

        //agrega el usuario y sus relaciones (perfil, ocupación, musica-favorita, tecnología-internet)
        usuarioF.create(u);
        
        
        out.println("<script>alert('registrado correctamente')</script>");
        out.println("<script>location.assign('index.html')</script>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
