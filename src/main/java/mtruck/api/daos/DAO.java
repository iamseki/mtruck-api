/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author christian.seki
 */
public abstract class DAO<E> {

    final String STRING_CONEXAO = "jdbc:postgresql://localhost/lp2";
    final String USUARIO = "postgres";
    final String SENHA = "admin";
    protected String TABELA;
    
    protected E preencheEntidade(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Implementar na classe filha."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<E> listar() throws SQLException {
        ArrayList<E> entidades = new ArrayList();

        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "SELECT * FROM " + TABELA;
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        E entidade = this.preencheEntidade(rs);
                        entidades.add(entidade);
                    }
                }
            }
        }
        return entidades;
    }
    
  
    public E pesquisar(UUID id) throws SQLException {
        E entidade = null;

        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "SELECT * FROM " + TABELA + " WHERE ID='" + id + "'";

            System.out.println("[Pesquisar] - SQL: " + SQL);
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        entidade = preencheEntidade(rs);
                    }
                }
            }
        } 
        return entidade;
    }
    
    public void salvar(E entidade)throws SQLException{
        throw new UnsupportedOperationException("Implementar na classe filha."); //To change body of generated methods, choose Tools | Templates.
    }
}
