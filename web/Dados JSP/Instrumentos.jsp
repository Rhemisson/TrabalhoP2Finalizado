<%-- 
    Document   : Instrumentos
    Created on : 16/06/2016, 09:27:56
    Author     : Hemis
--%>

<%@page import="br.javaweb.Produtos.Instrumento"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="Menu.jsp"/>
<br>
<h3>Lista de jogos disponíveis para compra:</h3>
<h5>${erro}</h5>
<br>
<table width='700' border='0'>
    <tr width = '%100'>
        <td width = '%40'>Imagem</td>
        <td width = '%10' >Nome</td>
        <td width = '%10' >Descrição</td>
        <td width = '%10' >Preço</td>
        <td width = '%20' colspan = '2'>Comprar</td>
    </tr>
    <c:forEach items="${listadejogos}" var="jg">
        <tr>
            <td width='%20'>
                <br>  <img SRC='${pageContext.request.contextPath}/Imagens/${inst.imagem}' />
            </td>
            <td width = '%10'>${inst.nome}</td>
            <td width = '%10'>${inst.descricao}</td>
            <td width = '%10'>${inst.preco}</td>
            <td width = '%20' colspan = '2'>
                <a href='${pageContext.request.contextPath}/IncluirNoCarrinho?codInstruemnto=${Instrumento.id}'>
                    <img SRC='${pageContext.request.contextPath}/Imagens/carrinho.gif' /></a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td align='right' colspan='7' class='tituloform'>
            <br>
            <form action="${pageContext.request.contextPath}/IncluirNoCarrinho" method="get">
                <b><input type="submit" value="Visualizar Carrinho"></b>
            </form>
            <form action="${pageContext.request.contextPath}/Dados JSP/Concluir.jsp" method="post">
                <b><input type="submit" value="  Concluir compra    "></b>
            </form>
        </td>
    </tr>
</table>