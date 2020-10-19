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
import java.util.logging.Level;
import java.util.logging.Logger;
import mtruck.api.entities.Auditoria;
/**
 *
 * @author GERU\christian.seki
 */
public class AuditoriaDAO implements DAO<Auditoria>{
    
    private final String STRING_CONEXAO = "jdbc:postgresql://localhost/lp2";
    private final String USUARIO = "postgres";
    private final String SENHA = "admin";
    private final String TABELA = "auditoria"; 

    @Override
    public List<Auditoria> listar() {
        ArrayList<Auditoria> logs = new ArrayList();

        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "SELECT * FROM " + TABELA;
            System.out.println("[Listar] - SQL: "+ SQL);
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Auditoria a = this.preencheAuditoria(rs);
                        logs.add(a);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuditoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logs;
    }

    @Override
    public void salvar(Auditoria a) {
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "INSERT INTO auditoria (descricao)"
                    + " VALUES('"+a.getDescricao()+"')";

            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuditoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Auditoria preencheAuditoria(ResultSet rs){
        Auditoria a = new Auditoria();
        try {
            a.setId(UUID.fromString(rs.getString("id")));
            a.setDescricao(rs.getString("descricao"));
            a.setData_criacao(rs.getDate("data_criacao"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @Override
    public Auditoria pesquisar(UUID id) {
        Auditoria a = new Auditoria();
        
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "SELECT * FROM " + TABELA + " WHERE ID='"+id+"'";
            
            System.out.println("[Pesquisar] - SQL: "+ SQL);
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        a = this.preencheAuditoria(rs);
                    }   
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuditoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
}
