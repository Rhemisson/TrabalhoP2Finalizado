<%-- 
    Document   : Menu
    Created on : 16/06/2016, 09:27:56
    Author     : Hemis
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bem-vindo ${sessionScope.logado.getLogin()}!</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pa css/Paginas.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pa css/FundoIMG.css"/>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h3 align="center">
                        Os melhores instrumentos pelo menor preço!
                    </h3>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <ul class="nav nav-tabs">
                        <li>
                            <a href="${pageContext.request.contextPath}/jsp/Inicio.jsp">Página inicial</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/ListaInstrumentos">Instrumentos</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/Logout">Sair</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>