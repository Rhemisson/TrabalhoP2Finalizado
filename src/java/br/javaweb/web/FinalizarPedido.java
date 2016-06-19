/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.web;

import java.io.IOException;
import br.javaweb.Produtos.*;
import br.javaweb.util.JavaWebException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FinalizarPedido extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mensagem = null;
        try {
            HttpSession session = req.getSession();
            AdicionarCarrinho carrinho = null;
            carrinho = (AdicionarCarrinho) session.getAttribute("AdicionarCarrinho");
            List<ItemP> item = carrinho.getItems();
            req.setAttribute("compra", item);
            RequestDispatcher rd = req.getRequestDispatcher("/Dados JSP/PedidoFinalizado.jsp");
            rd.forward(req, resp);
        } catch (ServletException ex) {
            mensagem = "Erro: Seu carrinho está vazio. Favor verificar.";
            req.setAttribute("erro", mensagem);
            RequestDispatcher rd = req.getRequestDispatcher("/Dados JSP/Concluir.jsp");
            rd.forward(req, resp);
        } catch (NullPointerException ex) {
            mensagem = "Erro: Seu carrinho está vazio. Favor verificar.";
            req.setAttribute("erro", mensagem);
            RequestDispatcher rd = req.getRequestDispatcher("/Dados JSP/Concluir.jsp");
            rd.forward(req, resp);
        }
    }
}
