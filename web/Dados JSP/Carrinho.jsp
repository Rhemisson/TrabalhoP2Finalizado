<%-- 
    Document   : Carrinho
    Created on : 16/06/2016, 09:27:56
    Author     : Hemis
--%>

<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="br.javaweb.Produtos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="Menu.jsp"/>
<br>
<h3>Carrinho de compras</h3>
<br>
<table border='0' width='700' border='0'>
    <tr>
        <td width = '%40'>Imagem</td>
        <td width = '%10' >Nome</td>
        <td width = '%10' >Descrição</td>
        <td width = '%10' >Preço</td>
        <td width='%20' class='tituloCampo'>Total</td>
    </tr>    
    <c:forEach items="${carrinho}" var="Inst">
        <tr>
            <td width='%20'>
               <br>   <img SRC='${pageContext.request.contextPath}/Imagens/${Inst.Instrumento.imagem}' />
            </td>
            <td width = '%10'>${Inst.Instrumentonome}</td>
            <td width = '%10'>${Inst.Instrumento.descricao}</td>
            <td width = '%10'>${Inst.Instrumento.preco}</td>
            <td width = '%20'>-</td>
        </c:forEach>
        <td width = '%20' colspan = '2'>${total}</td>
    </tr>
    <tr>
        <td align='right' colspan='7' class='tituloform'>
            <br><a HREF='${pageContext.request.contextPath}/ListaInstrumentos'>Voltar</A>
            <A HREF='${pageContext.request.contextPath}/ListaInstrumentos'><img src='${pageContext.request.contextPath}/Imagens/carrinho.gif' /></A>
        </td>
    </tr>
