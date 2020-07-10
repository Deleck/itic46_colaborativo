/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


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
import modelo.sesion.MusicaFacade;

/**
 *
 * @author alberto
 */
@WebServlet(name = "CtrlMusica", urlPatterns = {"/musica", "/addMusica", "/editMusica", "/deleteMusica"})
public class CtrlMusica extends HttpServlet {

    String url;
    @EJB
    private MusicaFacade musicaF;

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Musica> musicaList;
        Musica m;
        url = request.getServletPath();
        switch (url) {
            case "/musica":
                musicaList = musicaF.findAll();
                request.setAttribute("musicaList", musicaList);
                request.getRequestDispatcher("/WEB-INF/musica.jsp").forward(request, response);
                break;
            case "/editMusica":
                m = musicaF.find(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("accion", "Editar ");
                request.setAttribute("ruta", "editMusica ");
                request.setAttribute("musica", m);
                request.getRequestDispatcher("/WEB-INF/musicaFrm.jsp").forward(request, response);
                break;
            case "/deleteMusica":
                m = musicaF.find(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("accion", "Borrar ");
                request.setAttribute("ruta", "deleteMusica");
                request.setAttribute("musica", m);
                request.getRequestDispatcher("/WEB-INF/musicaFrm.jsp").forward(request, response);
                break;
            case "/addMusica":
                request.setAttribute("accion", "Agregar ");
                request.setAttribute("ruta", "addMusica ");
                request.getRequestDispatcher("/WEB-INF/musicaFrm.jsp").forward(request, response);
                break;
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Musica m;
        int id;
        
        url = request.getServletPath();
        try {
            PrintWriter out = response.getWriter();
            switch(url){
                case "/editMusica":
                    id = Integer.parseInt(request.getParameter("id"));
                    m = musicaF.find(id);
                    m.setMusica(request.getParameter("musica").toUpperCase());
                    m.setEstatus(Short.parseShort(request.getParameter("estatus")));
                    musicaF.edit(m);
                    out.println("<script>alert('guardado correctamente')</script>");
                    out.println("<script>location.assign('musica')</script>");
//                    response.sendRedirect("musica");
                    break;
                case "/addMusica":
                    m = new Musica();
                    m.setMusica(request.getParameter("musica").toUpperCase());
                    m.setEstatus(Short.parseShort(request.getParameter("estatus")));
                    musicaF.create(m);
                    out.println("<script>alert('agregado correctamente')</script>");
                    out.println("<script>location.assign('musica')</script>");
//                    response.sendRedirect("musica");
                    break;
                case "/deleteMusica":
                    //hace un borrado físico (si quisiera borrado lógico tendría que usar edit)
                    id = Integer.parseInt(request.getParameter("id"));
                    m = musicaF.find(id);
                    musicaF.borrarLogicamente(m);
                    out.println("<script>alert('borrado correctamente')</script>");
                    out.println("<script>location.assign('musica')</script>");
                    break;
            }
        } catch (Exception e) {
            Logger.getLogger(CtrlMusica.class.getName()).log(Level.SEVERE, null, e);
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
