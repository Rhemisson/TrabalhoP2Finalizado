/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.web;

import br.javaweb.Produtos.Usuario;
import br.javaweb.dao.UsuarioDAO;
import br.javaweb.util.JavaWebException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class NovoUsuario extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String contexto = req.getContextPath();

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        String mensagem = null;

        Usuario objLogin = new Usuario(login, senha);

        try {
            Usuario newUsr = new UsuarioDAO().setUsuarioESenha(login, senha);
            HttpSession sessao = req.getSession();
            sessao.setAttribute("logado", objLogin);
            resp.sendRedirect(contexto + "/Dados JSP/Inicio.jsp");
        } catch (JavaWebException ex) {
            Logger.getLogger(NovoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Usuário já cadastrado!";
            req.setAttribute("erro", mensagem);
            RequestDispatcher rd = req.getRequestDispatcher("/Dados JSP/CadastroUsuario.jsp");
            rd.forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(NovoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Usuário já cadastrado!";
            req.setAttribute("erro", mensagem);
            RequestDispatcher rd = req.getRequestDispatcher("/Dados JSP/CadastroUsuario.jsp");
            rd.forward(req, resp);
        }
    }
}
