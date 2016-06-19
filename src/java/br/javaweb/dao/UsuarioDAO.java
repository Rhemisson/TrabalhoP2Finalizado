/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.dao;

import br.javaweb.Produtos.Usuario;
import br.javaweb.util.JavaWebException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO {

    private final String SELECT_USUARIO = "SELECT LOGIN, SENHA FROM USUARIOS WHERE LOGIN = ? AND SENHA = ?";
    private final String INSERT_USUARIO = "INSERT INTO USUARIOS(LOGIN, SENHA) VALUES (?,?)";

    public boolean getLoginESenha(String login, String senha) throws JavaWebException {

        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet userBD = null;
        Usuario usrs = new Usuario(login, senha);

        try {
            conn = GerenciadorConexoes.getConexao();

            prepStmt = conn.prepareStatement(SELECT_USUARIO);
            prepStmt.setString(1, login);
            prepStmt.setString(2, senha);
            userBD = prepStmt.executeQuery();

            if (userBD.next()) {
                if (usrs.getLogin().equals(login) && usrs.getSenha().equals(senha)) {
                    return true;
                }
            } else {
                return false;
            }
        } catch (SQLException E) {
            return false;
        }
        return false;
    }

    public Usuario setUsuarioESenha(String login, String senha) throws JavaWebException, SQLException {

        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet insert = null;
        Usuario usrs = new Usuario(login, senha);

        try {
            conn = GerenciadorConexoes.getConexao();
            prepStmt = conn.prepareStatement(INSERT_USUARIO);
            prepStmt.setString(1, login);
            prepStmt.setString(2, senha);
            prepStmt.execute();
            usrs.setLogin(login);
            usrs.setSenha(senha);
        } catch (SQLException E) {
            String msg = "Erro ao inserir usuario: " + E.getMessage();
            JavaWebException ge = new JavaWebException(msg, E);
            throw ge;
        } finally {
            GerenciadorConexoes.closeAll(conn, prepStmt, insert);
        }
        return usrs;
    }
}
