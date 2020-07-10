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
import modelo.entidades.Ocupacion;
import modelo.sesion.OcupacionFacade;

/**
 *
 * @author alberto
 */
@WebServlet(name = "CtrlOcupacion", urlPatterns = {"/ocupacion", "/addOcupacion", "/editOcupacion", "/deleteOcupacion"})
public class CtrlOcupacion extends HttpServlet {

    String url;
    @EJB
    private OcupacionFacade ocupacionF;

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
        List<Ocupacion> ocupacionList;
        Ocupacion o;
        url = request.getServletPath();
        switch (url) {
            case "/ocupacion":
                ocupacionList = ocupacionF.findAll();
                request.setAttribute("ocupacionList", ocupacionList);
                request.getRequestDispatcher("/WEB-INF/ocupacion.jsp").forward(request, response);
                break;
            case "/editOcupacion":
                o = ocupacionF.find(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("accion", "Editar ");
                request.setAttribute("ruta", "editOcupacion ");
                request.setAttribute("ocupacion", o);
                request.getRequestDispatcher("/WEB-INF/ocupacionFrm.jsp").forward(request, response);
                break;
            case "/deleteOcupacion":
                o = ocupacionF.find(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("accion", "Borrar ");
                request.setAttribute("ruta", "deleteOcupacion");
                request.setAttribute("ocupacion", o);
                request.getRequestDispatcher("/WEB-INF/ocupacionFrm.jsp").forward(request, response);
                break;
            case "/addOcupacion":
                request.setAttribute("accion", "Agregar ");
                request.setAttribute("ruta", "addOcupacion ");
                request.getRequestDispatcher("/WEB-INF/ocupacionFrm.jsp").forward(request, response);
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
        Ocupacion o;
        int id;
        
        url = request.getServletPath();
        try {
            PrintWriter out = response.getWriter();
            switch(url){
                case "/editOcupacion":
                    id = Integer.parseInt(request.getParameter("id"));
                    o = ocupacionF.find(id);
                    o.setOcupacion(request.getParameter("ocupacion").toUpperCase());
                    o.setEstatus(Short.parseShort(request.getParameter("estatus")));
                    ocupacionF.edit(o);
                    out.println("<script>alert('guardado correctamente')</script>");
                    out.println("<script>location.assign('ocupacion')</script>");
//                    response.sendRedirect("ocupacion");
                    break;
                case "/addOcupacion":
                    o = new Ocupacion();
                    o.setOcupacion(request.getParameter("ocupacion").toUpperCase());
                    o.setEstatus(Short.parseShort(request.getParameter("estatus")));
                    ocupacionF.create(o);
                    out.println("<script>alert('agregado correctamente')</script>");
                    out.println("<script>location.assign('ocupacion')</script>");
//                    response.sendRedirect("ocupacion");
                    break;
                case "/deleteOcupacion":
                    //hace un borrado físico (si quisiera borrado lógico tendría que usar edit)
                    id = Integer.parseInt(request.getParameter("id"));
                    o = ocupacionF.find(id);
                    //borrado lógico
                    o.setEstatus(Short.parseShort("0"));
                    ocupacionF.edit(o);
                    out.println("<script>alert('borrado correctamente')</script>");
                    out.println("<script>location.assign('ocupacion')</script>");
                    break;
            }
        } catch (Exception e) {
            Logger.getLogger(CtrlOcupacion.class.getName()).log(Level.SEVERE, null, e);
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
