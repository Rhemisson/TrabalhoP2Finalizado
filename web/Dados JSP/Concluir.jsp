<%-- 
    Document   : Concluir
    Created on : 16/06/2016, 09:27:56
    Author     : Hemis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Menu.jsp"/>
<br>
<h3>Concluir a compra</h3>
<form name='dadosCliente' method='post' action='${pageContext.request.contextPath}/FinalizarPedido' >
    <td class='container-fluid'>
        <table>
            <h5>Favor informar seus dados pessoais:</h5>
            <tr>
                <td class='container-fluid'>Nome</td>
                <td class='container-fluid'><input name='nome' type='text'></td>
            </tr>
            <tr>
                <td class='container-fluid'>Data Nascimento/td>
                <td class='container-fluid'><input name='Data Nascimento' type='DataTime'></td>
            </tr>
            <tr>
                <td class='container-fluid'>CPF</td>
                <td class='container-fluid'><input name='cpf' type='text'></td>
            </tr>
        </table>
        <table>
            <tr>
                <h5>Favor informar seu endereço:</h5>
                <td class='container-fluid'>Rua</td>
                <td class='container-fluid'><input name='rua' type='text'></td>
            </tr>
            <tr>
                <td class='container-fluid'>Bairro</td>
                <td class='container-fluid'><input name='bairro' type='text'></td>
            </tr>
            <tr>
                <td class='container-fluid'>Cidade</td>
                <td class='container-fluid'><input name='cidade' type='text'></td>
            </tr>
            <tr>
                <td class='container-fluid'>Estado</td>
                <td class='container-fluid'><input name='estado' type='text'></td>
            </tr>
        </table>
        <br>
        <b><input type='submit' value='Concluir'></b>
        <h5>${erro}</h5>
</form>
