/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import mtruck.api.entities.Viagem;

/**
 *
 * @author chseki
 */
public class ViagemDAO extends DAO<Viagem>{
    public ViagemDAO(){
        super.TABELA = "viagens";
        String SPRING_DATASOURCE_URL = System.getenv("SPRING_DATASOURCE_URL");
        if(SPRING_DATASOURCE_URL != null){
            super.STRING_CONEXAO = "jdbc:" + SPRING_DATASOURCE_URL;
            super.USUARIO = System.getenv("SPRING_DATASOURCE_USERNAME");
            super.SENHA = System.getenv("SPRING_DATASOURCE_PASSWORD");
        }
    }
    
    @Override
    protected Viagem preencheEntidade(ResultSet rs) throws SQLException {
        Viagem v = new Viagem();
        
        v.setId(UUID.fromString(rs.getString("id")));
        v.setCaminhao_id(UUID.fromString(rs.getString("caminhao_id")));
        v.setStatus(rs.getString("status"));
        v.setEndereco_origem(rs.getString("endereco_origem"));
        v.setEndereco_destino(rs.getString("endereco_destino"));
        v.setPeso_final(rs.getFloat("peso_final"));
        v.setPeso_inicial(rs.getFloat("peso_inicial"));
        v.setData_inicial(rs.getTimestamp("data_inicial"));
        v.setData_final(rs.getTimestamp("data_final"));
        
        return v;
    }
}
