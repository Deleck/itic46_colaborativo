/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import business.BsPerfil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import modelo.sesion.PerfilFacade;
import modelo.sesion.TecnologiaFacade;
import modelo.sesion.UsuarioFacade;


/**
 *
 * @author alberto
 */
@WebServlet(name = "CtrlPerfiles", urlPatterns = {"/perfiles", "/editPerfiles", "/deletePerfiles"})
public class CtrlPerfiles extends HttpServlet {

    @EJB
    private PerfilFacade perfilF;
    @EJB
    private UsuarioFacade usuarioF;
    @EJB
    private MusicaFacade musicaF;
    @EJB
    private OcupacionFacade ocupacionF;
    @EJB
    private TecnologiaFacade tecnologiaF;
    @EJB
    private BsPerfil perfilB;

    String url;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Perfil> listaPerfiles;
        PrintWriter out = response.getWriter();
        url = request.getServletPath();
        switch (url) {
            case "/perfiles":
                listaPerfiles = perfilF.findAll();
                request.setAttribute("perfiles", listaPerfiles);
                request.getRequestDispatcher("/WEB-INF/perfiles.jsp").forward(request, response);
                break;
            case "/editPerfiles":
                Usuario usuario = usuarioF.find(Integer.parseInt(request.getParameter("id")));
                //obtiene catálogos para mostrarlos en el formulario
                List<Musica> listaMusica = musicaF.findAll();
                List<Ocupacion> listaOcupacion = ocupacionF.findAll();
                List<Tecnologia> listaTecnologia = tecnologiaF.findAll();
                request.setAttribute("listaMusica", listaMusica);
                request.setAttribute("listaOcupacion", listaOcupacion);
                request.setAttribute("listaTecnologia", listaTecnologia);
                request.setAttribute("titulo", "Editar Perfil");
                request.setAttribute("action", "editPerfiles");
                request.setAttribute("perfil", usuario.getPerfilList().get(usuario.getPerfilList().size() - 1));
                request.getRequestDispatcher("/WEB-INF/registroFrm.jsp").forward(request, response);
                break;
            case "/deletePerfiles":
                usuario = usuarioF.find(Integer.parseInt(request.getParameter("id")));
                //obtiene catálogos para mostrarlos en el formulario
                listaMusica = musicaF.findAll();
                listaOcupacion = ocupacionF.findAll();
                listaTecnologia = tecnologiaF.findAll();
                request.setAttribute("listaMusica", listaMusica);
                request.setAttribute("listaOcupacion", listaOcupacion);
                request.setAttribute("listaTecnologia", listaTecnologia);
                request.setAttribute("titulo", "Borrar Perfil");
                request.setAttribute("action", "deletePerfiles");
                request.setAttribute("perfil", usuario.getPerfilList().get(usuario.getPerfilList().size() - 1));
                request.getRequestDispatcher("/WEB-INF/registroFrm.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            Usuario u;
            url = request.getServletPath();
            switch (url) {
                case "/editPerfiles":
                    //obtiene los datos del formulario
                    String txtId = request.getParameter("id");
                    String txtUsuario = request.getParameter("usuario");
                    String txtPassword = request.getParameter("password");
                    String txtIdTecnologias[] = request.getParameterValues("tecnologia");
                    String txtGenero = request.getParameter("genero");
                    String txtIdOcupacion = request.getParameter("ocupacion");
                    String txtOtraOcupacion = request.getParameter("otraOcupacion");
                    String txtIdMusica[] = request.getParameterValues("musica");
                    String txtComentarios = request.getParameter("comentarios");

                    perfilB.edit(txtId, txtUsuario, txtPassword, txtIdTecnologias, 
                            txtGenero, txtIdOcupacion, txtOtraOcupacion, txtIdMusica, 
                            txtComentarios);

                    out.println("<script>alert('registrado correctamente')</script>");
                    out.println("<script>location.assign('perfiles')</script>");
                    break;
                case "/deletePerfiles":
                    //obtiene el entity del usuario
                    u = usuarioF.find(Integer.parseInt(request.getParameter("id")));
                    u.setEstatus(Short.parseShort("0"));
                    usuarioF.edit(u);
                    out.println("<script>alert('eliminado correctamente')</script>");
                    out.println("<script>location.assign('perfiles')</script>");
                    
                    break;

            }
        } catch (Exception e) {
            Logger.getLogger(CtrlPerfiles.class.getName()).log(Level.SEVERE, null, e);
        }

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
