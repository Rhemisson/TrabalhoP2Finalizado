<%-- 
    Document   : PedidoFinalizado
    Created on : 16/06/2016, 09:27:56
    Author     : Hemis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Menu.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br>
<h2>Obrigado por comprar conosco!</h2>
<h3>Dados do pedido:</h3>
<table>
    <h5>Dados pessoais:</h5>
    <tr>
        <td class='container-fluid'>Nome:</td>
        <td class='container-fluid'>${param.nome}</td>
    </tr>
     <tr>
        <td class='container-fluid'>Data Nascimento:</td>
        <td class='container-fluid'>${param.DataNascimento}</td>
    </tr>
    <tr>
        <td class='container-fluid'>CPF:</td>
        <td class='container-fluid'>${param.cpf}</td>
    </tr>
</table>
<table>
    <tr>
    <h5>Endereço de entrega:</h5>
    <td class='container-fluid'>Rua:</td>
    <td class='container-fluid'>${param.rua}</td>
</tr>
<tr>
    <td class='container-fluid'>Bairro:</td>
    <td class='container-fluid'>${param.bairro}</td>
</tr>
<tr>
    <td class='container-fluid'>Cidade:</td>
    <td class='container-fluid'>${param.cidade}</td>
</tr>
<tr>
    <td class='container-fluid'>Estado:</td>
    <td class='container-fluid'>${param.estado}</td>
</tr>
<table border='0' width='700' border='0'>
    <tr>
    <h5>Produtos:</h5>
    <td width = '%40'>Imagem</td>
    <td width = '%10' >Nome</td>
    </tr>    
    <c:forEach items="${compra}" var="item">
        <tr>
            <td width='%20'>
               <br>   <img SRC='${pageContext.request.contextPath}/Imagens/${item.Instrumento.imagem}' />
            </td>
            <td width = '%10'>${item.Instrumento.nome}</td>
        </c:forEach>
        <td width = '%20' colspan = '2'></td>
    </tr>
</table>
