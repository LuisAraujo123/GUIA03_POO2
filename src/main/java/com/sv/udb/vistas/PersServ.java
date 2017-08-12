/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.controlador.PersCtrl;
import com.sv.udb.modelo.Pers;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.ImageIcon;

/**
 *
 * @author bernardo
 */
@WebServlet(name = "PersServ", urlPatterns = {"/PersServ"})
public class PersServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean esValido = request.getMethod().equals("POST");
        String mens = "";
        System.err.println("Entra al process");
        if(!esValido)
        {
            response.sendRedirect(request.getContextPath() + "/mantenimiento.jsp");
        }
        else {
            try{
                String CRUD = request.getParameter("btonPers");
                if (CRUD.equals("Guardar"))
                {
                    Pers obje = new Pers();
                    request.setAttribute("nomb", obje.getNombPers());
                    request.setAttribute("mail", obje.getMailPers());
                    request.setAttribute("apel", obje.getApelPers());
                    Part filePart = request.getPart("imag");
                    byte[] foto = null;
                    System.err.println(filePart + " esto es");
                    int tamaFoto = (int)filePart.getSize();
                    System.err.println("tomo la imagen");
                    foto = new byte[tamaFoto];
                    try(DataInputStream imagen = new DataInputStream(filePart.getInputStream())) 
                    {
                        imagen.readFully(foto);
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    if (tamaFoto > 0) {
                        obje.setFotoPers(foto);
                    }
                    if (new PersCtrl().guar(obje))
                    {
                        mens = "guardado";
                        request.removeAttribute("codi");
                        request.removeAttribute("nomb");
                        request.removeAttribute("apel");
                        request.removeAttribute("mail");
                        request.removeAttribute("imag");
                    }
                }
                else if (CRUD.equals("Consultar"))
                {
                    //El operador unario sirve como if para validar que el radio buton este selecionado, si no lo esta devuelve -1
                    int codi = Integer.parseInt(request.getParameter("codiPersRadi").isEmpty() ? "-1" : request.getParameter("codiPersRadi"));
                    Pers obje = new PersCtrl().consUno(codi);
                    if (obje != null)
                    {
                        try {
                            request.setAttribute("codi", obje.getCodiPers());
                            request.setAttribute("nomb", obje.getNombPers());
                            request.setAttribute("mail", obje.getMailPers());
                            request.setAttribute("apel", obje.getApelPers());
                            byte[] photo = obje.getFotoPers();
                            BufferedImage img = null;
                            img = ImageIO.read(new ByteArrayInputStream(obje.getFotoPers()));
                            ImageIcon icon = new ImageIcon(img);
                            request.setAttribute("imag", icon);
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                            }
                    }
                    else
                    {
                        mens = "Error al consultar";
                    }
                }
                else if  (CRUD.equals("Eliminar"))
                {
                    int codi = Integer.parseInt(request.getParameter("codiTipoRadi").isEmpty() ? "-1" : request.getParameter("codiTipoRadi"));
                    if (codi != -1)
                    {
                        Pers obje = new Pers();
                        obje.setCodiPers(codi);
                        if (new PersCtrl().dele(obje))
                        {
                            mens = "Datos eliminados";
                            request.removeAttribute("codi");
                            request.removeAttribute("nomb");
                            request.removeAttribute("apel");
                            request.removeAttribute("mail");
                            request.removeAttribute("imag");
                        }
                        else
                        {
                            request.removeAttribute("codi");
                            request.removeAttribute("nomb");
                            request.removeAttribute("apel");
                            request.removeAttribute("mail");
                            request.removeAttribute("imag");
                            mens = "Error al eliminar";
                        }
                    }
                }
                 
                else if (CRUD.equals("Modificar"))
                {
                    System.err.println("Entra a modificar");
                    int codi = Integer.parseInt(request.getParameter("codi").isEmpty() ? "-1" : request.getParameter("codi"));
                    if (codi != -1)
                    {
                        System.err.println("Entra se supone hizo la modificacion");
                        Pers obje = new Pers();
                        obje.setCodiPers(codi);
                        obje.setNombPers(request.getParameter("nomb"));
                        obje.setApelPers(request.getParameter("apel"));
                        obje.setMailPers(request.getParameter("mail"));
                        Part filePart = request.getPart("imag");
                        byte[] foto = null;
                        System.err.println(filePart + " esto es");
                        int tamaFoto = (int)filePart.getSize();
                        System.err.println("tomo la imagen");
                        foto = new byte[tamaFoto];
                        try(DataInputStream imagen = new DataInputStream(filePart.getInputStream())) 
                        {
                            imagen.readFully(foto);
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        if (tamaFoto > 0) {
                            obje.setFotoPers(foto);
                        }
                        if (new PersCtrl().upda(obje))
                        {
                            mens = "Datos modificados";
                            request.setAttribute("estModi", "disabled");
                            request.setAttribute("estGuar", "enable");
                            request.removeAttribute("codi");
                            request.removeAttribute("nomb");
                            request.removeAttribute("apel");
                            request.removeAttribute("mail");
                            request.removeAttribute("imag");

                        }
                        else
                        {
                            request.setAttribute("estModi", "disabled");
                            request.setAttribute("estGuar", "enable");
                            request.removeAttribute("codi");
                            request.removeAttribute("nomb");
                            request.removeAttribute("apel");
                            request.removeAttribute("mail");
                            request.removeAttribute("imag");

                            mens = "Error al modificar";
                        }
                    }                   
                }
                request.setAttribute("mensAler", mens);
                request.getRequestDispatcher("/indexTipoDenu.jsp").forward(request, response);
                
            }
            catch (Exception ex){
                System.err.println(ex.getMessage());
                ex.printStackTrace();
                request.getRequestDispatcher("/indexTipoDenu.jsp").forward(request, response);
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
