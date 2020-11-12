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
public class DatalogDAO extends DAO<Datalog> {

    public DatalogDAO() {
        super.TABELA = "datalog";
        String SPRING_DATASOURCE_URL = System.getenv("SPRING_DATASOURCE_URL");
        if(SPRING_DATASOURCE_URL != null){
            super.STRING_CONEXAO = "jdbc:" + SPRING_DATASOURCE_URL;
            super.USUARIO = System.getenv("SPRING_DATASOURCE_USERNAME");
            super.SENHA = System.getenv("SPRING_DATASOURCE_PASSWORD");
        }
    }

    @Override
    protected Datalog preencheEntidade(ResultSet rs) throws SQLException {
        Datalog d = new Datalog();
        d.setId(UUID.fromString(rs.getString("id")));
        d.setLatitude(rs.getString("latitude"));
        d.setLongitude(rs.getString("longitude"));
        d.setPeso_atual(rs.getFloat("peso_atual"));
        d.setViagem_id(UUID.fromString(rs.getString("viagem_id")));
        d.setData(rs.getTimestamp("data"));

        return d;
    }

    @Override
    public void salvar(Datalog d)throws SQLException {
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "INSERT INTO " + super.TABELA + " (latitude,longitude,peso_atual,viagem_id)"
                    + " VALUES('" + d.getLatitude() + "','" + d.getLongitude() + "','" + d.getPeso_atual() + "','" + d.getViagem_id() + "')";

            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        }
    }
}
