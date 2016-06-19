package br.javaweb.dao;

import br.javaweb.dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.javaweb.util.JavaWebException;

public class GerenciadorConexoes {

    private static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
    private static final String BANCO_DE_DADOS = "lojainstrumentos";
    private static final String IP = "localhost"; //"192.168.0.1";
    private static final String USUARIO = "root";
    private static final String SENHA = "root123";
    
    
    private static final String STR_MYSQL = "jdbc:mysql://" + IP + ":3306/" + BANCO_DE_DADOS;
    public static Connection getConexao() throws JavaWebException {
        Connection conn = null;
        try {
            Class.forName(DRIVER_MYSQL);
            conn = DriverManager.getConnection(STR_MYSQL, USUARIO, SENHA);
            System.out.println("[ConnectionManager]: Obtendo conexao");
            return conn;
        } catch (ClassNotFoundException e) {
            String errorMsg = "Driver nao encontrado";
            throw new JavaWebException(errorMsg, e);
        }  catch (SQLException e) {
            String errorMsg = "Erro ao obter a conexao";
            throw new JavaWebException(errorMsg, e);
        }
    }

    public static void closeAll(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (conn != null || stmt != null) {
                closeAll(conn, stmt);
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeAll(Connection conn, Statement stmt) {
        try {
            if (conn != null) {
                closeAll(conn);
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
