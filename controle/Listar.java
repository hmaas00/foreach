package controle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

import negocio.Compra;
import negocio.Empacotador;
import negocio.Produto;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael.Soares
 */
@WebServlet("/Listar")
public class Listar extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        //empacotar produtos em uma compra
        
        String [] selecionados = request.getParameterValues("selecionado");
        
        Empacotador emp = new Empacotador();
        //Empacotador emp = (Empacotador) request.getAttribute("empacotador");
        
        emp.addCompra(selecionados);
        
        for(String s : selecionados) {
        	System.out.println(s);
        }
        
        
        /*
        
        Compra c1 = new Compra(prods, 1982, Calendar.MARCH , 12);
        
        prods2.add(p1);
        prods2.add(p2);
        Compra c2 = new Compra(prods2, 2001, Calendar.SEPTEMBER , 11);
        
        ArrayList<Compra> compras = new ArrayList<>();
        
        compras.add(c1);
        compras.add(c2);
        */
        request.setAttribute("compras", emp.getCompras());
        
        request.getRequestDispatcher("lista.jsp")
                .forward(request, response);
        
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