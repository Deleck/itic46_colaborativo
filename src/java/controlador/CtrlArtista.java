/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.entidades.Album;
import modelo.entidades.Artista;
import modelo.entidades.Musica;
import modelo.sesion.AlbumFacade;
import modelo.sesion.ArtistaFacade;
import modelo.sesion.MusicaFacade;

/**
 *
 * @author alberto
 */
@WebServlet(name = "CtrlArtista", urlPatterns = {"/artista", "/addArtista", "/editArtista", "/deleteArtista"})
public class CtrlArtista extends HttpServlet {

    String url;
    @EJB
    private ArtistaFacade artistaF;
    @EJB
    private MusicaFacade musicaF;
    @EJB
    private AlbumFacade albumF;

    List<String> listaDeCss = new ArrayList<>();
    List<String> listaDeJs = new ArrayList<>();

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
        List<Artista> artistaList;
        url = request.getServletPath();
        //cargar las listas para css y js
        listaDeCss.add("<link href='recursos/form-validation.css\' rel='stylesheet\'>");
        listaDeJs.add("<script src='recursos/form-validation.js'></script>");
        listaDeJs.add("<script src='recursos/funciones.js\'></script>");
        request.setAttribute("listaDeCss", listaDeCss);
        request.setAttribute("listaDeJs", listaDeJs);
        switch (url) {
            case "/artista":
                request.setAttribute("listaDeCss", listaDeCss);
                request.setAttribute("listaDeJs", listaDeJs);

                artistaList = artistaF.findAll();
                request.setAttribute("artistas", artistaList);
                request.getRequestDispatcher("/WEB-INF/artista.jsp").forward(request, response);
                break;
            case "/addArtista":
                request.setAttribute("action", "addArtista");
                request.setAttribute("titulo", "Agregar artista");
                request.setAttribute("listaMusica", musicaF.findAll());
                request.getRequestDispatcher("/WEB-INF/artistaFrm.jsp").forward(request, response);
                break;
            case "/editArtista":
                request.setAttribute("art", artistaF.find(Integer.parseInt(request.getParameter("id"))));
                request.setAttribute("action", "editArtista");
                request.setAttribute("titulo", "Editar artista");
                request.setAttribute("listaMusica", musicaF.findAll());
                request.getRequestDispatcher("/WEB-INF/artistaFrm.jsp").forward(request, response);
                break;
            case "/deleteArtista":
                request.setAttribute("art", artistaF.find(Integer.parseInt(request.getParameter("id"))));
                request.setAttribute("action", "deleteArtista");
                request.setAttribute("titulo", "Borrar artista");
                request.setAttribute("listaMusica", musicaF.findAll());
                request.getRequestDispatcher("/WEB-INF/artistaFrm.jsp").forward(request, response);
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
        PrintWriter out = response.getWriter();
        url = request.getServletPath();
        String nombre;
        String txtIdMusica[];
        String txtIdAlbum[];
        String txtTitulo[];
        String txtAño[];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Artista artista;
        List<Musica> listaMusica;
        switch (url) {
            case "/addArtista":
                //obtiene los datos del formulario
                nombre = request.getParameter("nombre");
                txtIdMusica = request.getParameterValues("musica");
                txtTitulo = request.getParameterValues("titulo");
                txtAño = request.getParameterValues("anio");
                if (txtIdMusica != null) {
                    artista = new Artista();
                    artista.setNombre(nombre);
                    listaMusica = new ArrayList<>();
                    for (String idM : txtIdMusica) {
                        Musica musica = musicaF.find(Integer.parseInt(idM));
                        listaMusica.add(musica);
                    }
                    artista.setMusicaList(listaMusica);

                    List<Album> albumList = null;
                    if (txtTitulo != null) {
                        albumList = new ArrayList<>();
                        for (int i = 0; i < txtTitulo.length; i++) {
                            Album a = new Album();
                            a.setTitulo(txtTitulo[i]);
                            try {
                                a.setAño(sdf.parse(txtAño[i]));
                            } catch (ParseException ex) {
                                Logger.getLogger(CtrlArtista.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            a.setArtistaid(artista);
                            albumList.add(a);
                        }
                    }
                    artista.setAlbumList(albumList);
                    artistaF.create(artista);
                    out.println("<script>alert('registrado correctamente')</script>");
                    out.println("<script>location.assign('artista')</script>");
                }
                break;
            case "/editArtista":
                txtIdMusica = request.getParameterValues("musica");
                txtTitulo = request.getParameterValues("titulo");
                txtIdAlbum = request.getParameterValues("idAlbum");
                txtAño = request.getParameterValues("anio");

                if (txtIdMusica != null) {

                    artista = artistaF.find(Integer.parseInt(request.getParameter("id")));

                    //borrarDeArtista() borra todos los albumes previamente almacenados, 
                    //dicha estrategia dependerá de las reglas de negocio (en este caso, 
                    //no se utilizan los albumes en ninguna otra parte, por esa razón
                    //lo borramos físicamente
                    albumF.borrarDeArtista(artista);

                    artista.setNombre(request.getParameter("nombre"));
                    listaMusica = new ArrayList<>();
                    for (String idM : txtIdMusica) {
                        Musica musica = musicaF.find(Integer.parseInt(idM));
                        listaMusica.add(musica);
                    }
                    artista.setMusicaList(listaMusica);
                    artista.getAlbumList().clear();
                    if (txtTitulo != null) {
                        List<Album> albumList = new ArrayList<>();
                        for (int i = 0; i < txtTitulo.length; i++) {
                            Album a = new Album();
                            a.setTitulo(txtTitulo[i]);
                            try {
                                a.setAño(sdf.parse(txtAño[i]));
                            } catch (ParseException ex) {
                                Logger.getLogger(CtrlArtista.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            a.setArtistaid(artista);
                            albumList.add(a);
                        }

                        artista.setAlbumList(albumList);
                    }
                    artistaF.edit(artista);
                    out.println("<script>alert('registrado correctamente')</script>");
                    out.println("<script>location.assign('artista')</script>");
                }
                break;
            case "/deleteArtista":
                artista = artistaF.find(Integer.parseInt(request.getParameter("id")));
                artistaF.remove(artista);
                out.println("<script>alert('registrado correctamente')</script>");
                out.println("<script>location.assign('artista')</script>");
                break;
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
