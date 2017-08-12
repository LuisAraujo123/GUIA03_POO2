/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.utilidades.Correos;
import com.sv.udb.utilidades.CorreosAlter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.mail.Message;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bernardo
 */
@WebServlet(name = "EnviarCorreoServ", urlPatterns = {"/EnviarCorreoServ"})
public class EnviarCorreoServ extends HttpServlet {

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
            System.err.println("No es valido ?");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        else {
            try{
                System.err.println("si es valido");
                String CRUD = request.getParameter("btonMail");
                if (CRUD.equals("Enviar"))
                {   
                    System.err.println("Si existe enviar !");
                    String para = request.getParameter("mailPers01");
                    String CC = request.getParameter("mailPers02");
                    String CCO = request.getParameter("mailPers03");
                    if (para.equals(CC)|| para.equals(CCO))
                    {
                        System.err.println("Destinatarios duplicados");
                        mens = "Seleccione distintos destinatarios";
                    }
                    else
                    {
                        System.err.println("A punto de enviarlo");
                        String mensMail = request.getParameter("mensaje");
                        String asunto = request.getParameter("asunto");
                        System.err.println("");
                        Correos obje = new Correos();
                        obje.mailEnvi();
                        obje.actuMail(mensMail, para, asunto);
                        if (obje.SendMail(Message.RecipientType.TO))
                        {
                            if (!CC.equals(""))
                            {
                                obje.actuMail(mensMail, CC, asunto);
                                if (obje.SendMail(Message.RecipientType.CC))
                                {
                                    System.out.println("Enviado a CC");
                                }
                            }
                            if (!CCO.equals(""))
                            {
                                obje.actuMail(mensMail, CCO, asunto);
                                if (obje.SendMail(Message.RecipientType.BCC))
                                {
                                    System.out.println("Enviado a CCO");
                                }
                            }
                            mens = "Mensaje enviado";
                        }
                        else
                        {
                            System.err.println("Problema al enviarlo");
                        }
                    }                    
                }
                else if  (CRUD.equals("Cancelar"))
                {
                    
                }
                request.setAttribute("mensAler", mens);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                
            }
            catch (Exception ex){
                System.err.println(ex.getMessage());
                ex.printStackTrace();
                request.getRequestDispatcher("/index.jsp").forward(request, response);
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
