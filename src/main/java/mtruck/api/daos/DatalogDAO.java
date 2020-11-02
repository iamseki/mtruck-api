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
import mtruck.api.entities.Datalog;

/**
 *
 * @author GERU\christian.seki
 */
public class DatalogDAO extends DAO<Datalog>{
     
    public DatalogDAO(){
        super.TABELA = "datalog";
    }
    
    @Override
    protected Datalog preencheEntidade(ResultSet rs){
        Datalog d = new Datalog();
        try {
            d.setId(UUID.fromString(rs.getString("id")));
            d.setLatitude(rs.getString("latitude"));
            d.setLongitude(rs.getString("longitude"));
            d.setPeso_atual(rs.getFloat("peso_atual"));
            d.setStatus_viagem(rs.getString("status_viagem"));
            d.setData(rs.getDate("data"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return d;
    }

    @Override
    public void salvar(Datalog d) {
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "INSERT INTO datalog (latitude,longitude,peso_atual,status_viagem)"
                    + " VALUES('"+d.getLatitude()+"','" + d.getLongitude() + "','" + d.getPeso_atual() + "','" + d.getStatus_viagem()+"')";
            
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuditoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
