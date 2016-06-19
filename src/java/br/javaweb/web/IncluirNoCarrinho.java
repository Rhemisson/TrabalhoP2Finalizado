/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.web;


import br.javaweb.Produtos.Instrumento;
import br.javaweb.Produtos.*;
import br.javaweb.dao.LInstrumentosDAO;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class IncluirNoCarrinho extends HttpServlet {

    List<Instrumento> listaDeInstrumentoCarrinho = new ArrayList<Instrumento>();
    double totalValor;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String mensagem = null;
        try {
            Instrumento InstrumentoSelecionado = getInstrumentoSelecionado(req);
            totalValor += InstrumentoSelecionado.getPrecoNormal();
            incluirInstrumentoCarrinho(req, InstrumentoSelecionado);
            HttpSession session = req.getSession();
            AdicionarCarrinho carrinho = null;
            carrinho = (AdicionarCarrinho) session.getAttribute("AdicionarCarrinho");
            List<ItemP> itens = carrinho.getItems();
            req.setAttribute("CarrinhoInstrumento", itens);
            req.setAttribute("total", getPrecoFormat(totalValor));
            RequestDispatcher rd = req.getRequestDispatcher("/Dados JSP/Carrinho.jsp");
            rd.forward(req, resp);
        } catch (ServletException ex) {
            try {
                HttpSession session = req.getSession();
                AdicionarCarrinho carrinho = null;
                carrinho = (AdicionarCarrinho) session.getAttribute("AdicionarCarrinho");
                List<ItemP> itens = carrinho.getItems();
                req.setAttribute("CarrinhoInstrumento", itens);
                req.setAttribute("total", getPrecoFormat(totalValor));
                RequestDispatcher rd = req.getRequestDispatcher("/Dados JSP/Carrinho.jsp");
                rd.forward(req, resp);
            } catch (ServletException ex1) {
            } catch (NullPointerException ex1) {
                mensagem = "Erro: Seu carrinho está vazio. Favor verificar.";
                req.setAttribute("erro", mensagem);
                RequestDispatcher rd = req.getRequestDispatcher("/ListaInstrumentos");
                rd.forward(req, resp);
            }
        } catch (NullPointerException ex) {
            mensagem = "Erro: Seu carrinho está vazio. Favor verificar.";
            req.setAttribute("erro", mensagem);
            RequestDispatcher rd = req.getRequestDispatcher("/ListaInstrumentos");
            rd.forward(req, resp);
        }
    }

    private Instrumento getInstrumentoSelecionado(HttpServletRequest req) throws ServletException {
        String strCodInstrumento = req.getParameter("codInstrumento");
        Instrumento instrumento = null;
        LInstrumentosDAO LInstrumentosDAO = new LInstrumentosDAO();

        try {
            int id = Integer.parseInt(strCodInstrumento);
            instrumento = LInstrumentosDAO.getInstrumentoId(id);
            System.out.println("[IncluirNoCarrinho:getInstrumentosSelecionado] instrumento selecionado ");
            System.out.println(instrumento);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        return instrumento;
    }

    private void incluirInstrumentoCarrinho(HttpServletRequest req, Instrumento produtoSelecionado) {
        System.out.println(produtoSelecionado);
        ItemP item = new ItemP(produtoSelecionado, 1);
        AdicionarCarrinho carrinho = null;

        HttpSession session = req.getSession();
        carrinho = (AdicionarCarrinho) session.getAttribute("AdicionarCarrinho");

        if (carrinho == null) {
            carrinho = new AdicionarCarrinho(item);
            session.setAttribute("AdicionarCarrinho", carrinho);
        } else {
            carrinho.addItem(item);
        }
    }

    public String getPrecoFormat(double valor) {
        NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance();
        String preco = formatadorMoeda.format(valor);
        return preco;
    }
}
