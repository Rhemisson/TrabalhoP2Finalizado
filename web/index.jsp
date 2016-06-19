<%-- 
    Document   : Index
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
        <title>LojaInstrumentos - Sua loja de Instrumentos!</title>
        <link rel="stylesheet" type="text/css" href='${pageContext.request.contextPath}/pa css/index.css'/>
        <link rel="stylesheet" type="text/css" href='${pageContext.request.contextPath}/pa css/FundoIMG.css'/>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h1>
                        Bem-vindo a Loja de Instrumentos!
                    </h1>
                    <br><br>
                    
                    <form action='${pageContext.request.contextPath}/AutenticaLogin' method="post" >
                        <h3>
                            <label>Login</label><br><br>
                            <input type="text" placeholder="Digite seu Login" name="login" required/><br><br>
                            <label>Senha</label><br><br>
                            <input  type="password" placeholder="Digite sua Senha" name="senha" required/><br><br>
                            <button type="submit" name="Entrar">ENTRAR</button><br>
                        </h3> 
                    </form>
                     <form action='${pageContext.request.contextPath}/index.jsp' method="post">
                         <button type="submit">CANCELAR </button>
                     </form><br>
                    <form action='${pageContext.request.contextPath}/Dados JSP/CadastroUsuario.jsp' method="post">
                        <button type="submit" name="cadastro">Clique aqui para se cadastrar!</button>
                    </form><br>
                    ${erro}
                </div>
            </div>
        </div>
    </body>
</html>
