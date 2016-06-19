/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.dao;

import br.javaweb.Produtos.Instrumento;
import br.javaweb.util.JavaWebException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LInstrumentosDAO {
    
private final String SELECT_BY_ID_QUERY = "select * from Instrumento where id = ? ";
    private final String SELECT_ALL_QUERY = "select * from Instrumento";
    
    public List<Instrumento> getCatalogoInstrumento() throws JavaWebException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Instrumento> listaInstrumento = new ArrayList<Instrumento>();
        try {
            conn = GerenciadorConexoes.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SELECT_ALL_QUERY);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                String imagem = rs.getString("imagem");
                double preco = rs.getFloat("preco");
                Instrumento j = new Instrumento(id, nome, descricao, imagem, preco);
                listaInstrumento.add(j);
            }
        } catch (SQLException e) {
            String msg = "[InstrumentosBD][getCatalogoInstrumento()]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            GerenciadorConexoes.closeAll(conn, stmt, rs);
        }
        return listaInstrumento;
    }
    
    public Instrumento getInstrumentoId(int id) throws JavaWebException {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Instrumento oInstrumento = null;
        try {
            conn = GerenciadorConexoes.getConexao();
            prepStmt = conn.prepareStatement(SELECT_BY_ID_QUERY);
            prepStmt.setInt(1, id);
            rs = prepStmt.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                String imagem = rs.getString("imagem");
                double preco = rs.getFloat("preco");
                oInstrumento = new Instrumento(id, nome, descricao, imagem, preco);
            }
        } catch (SQLException e) {
            String msg = "[InstrumentoDB][getInstrumentoId()]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            GerenciadorConexoes.closeAll(conn, prepStmt, rs);
        }
        return oInstrumento;
    }
}
