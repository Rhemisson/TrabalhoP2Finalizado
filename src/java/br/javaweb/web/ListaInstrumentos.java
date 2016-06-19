/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.web;
import br.javaweb.dao.LInstrumentosDAO;
import br.javaweb.util.JavaWebException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListaInstrumentos {
    
     
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LInstrumentosDAO Instrumento = new LInstrumentosDAO();
        List ListaDeInstrumento = null;
        try {
            ListaDeInstrumento = Instrumento.getCatalogoInstrumento();
            req.setAttribute("ListaInstrumentos", ListaDeInstrumento);
            RequestDispatcher rd = req.getRequestDispatcher("/Dados JSP/Instrumentos.jsp");
            rd.forward(req, resp);
        } catch (JavaWebException ex) {
            Logger.getLogger(AutenticaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
