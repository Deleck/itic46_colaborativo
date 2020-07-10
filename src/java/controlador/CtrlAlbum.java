/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.sesion.AlbumFacade;
import modelo.sesion.ArtistaFacade;


/**
 *
 * @author alberto
 */
@WebServlet(name = "CtrlAlbum", urlPatterns = {"/album", "/addAlbum", "/editAlbum", "/deleteAlbum"})
public class CtrlAlbum extends HttpServlet {
@EJB
private AlbumFacade albumF;
@EJB
private ArtistaFacade artistaF;
 String url;
    

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
        
        
        switch(url){
            case "/album":
                break;
                
            case "/addAlbum":
                request.setAttribute("artistas", artistaF.findAll());
                request.getRequestDispatcher("/WEB-INF/albumFrm.jsp").forward(request, response);
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
