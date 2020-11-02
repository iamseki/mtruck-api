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
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import mtruck.api.entities.Auditoria;
/**
 *
 * @author GERU\christian.seki
 */
public class AuditoriaDAO extends DAO<Auditoria>{
    
    public AuditoriaDAO(){
        super.TABELA = "auditoria";
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
    
    @Override
    protected Auditoria preencheEntidade(ResultSet rs){
        Auditoria a = new Auditoria();
        try {
            a.setId(UUID.fromString(rs.getString("id")));
            a.setDescricao(rs.getString("descricao"));
            a.setData_criacao(rs.getTimestamp("data_criacao"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
}
