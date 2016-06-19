<%-- 
    Document   : CadastroUsuario
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
        <title>Cadastro de Usuário</title>
        <link rel="stylesheet" type="text/css" href='${pageContext.request.contextPath}/pa css/index.css'/>
        <link rel="stylesheet" type="text/css" href='${pageContext.request.contextPath}/pa css/Fundo1.css'/>
    </head>
    <br>
        <h2>
           É Novo por aqui?<br><br>Favor informar o login e senha para efetuar seu cadastro:
        </h2>
        <form action='${pageContext.request.contextPath}/NovoUsuario' method="post" >
            <h3>
                <label>login</label><br>
                <input type="text" name="login" required/><br><br>
                <label>Senha</label><br>
                <input  type="password" name="senha" required/><br><br>
                <button type="submit">CADASTRAR</button>
        </form>
        <form action='${pageContext.request.contextPath}/index.jsp' method="post"><br>
            <button type="submit">CANCELAR</button>
        </form>
    </h3><br>
    ${erro}
</body>
</html>
