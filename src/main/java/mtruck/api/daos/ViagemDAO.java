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
import mtruck.api.dtos.ListaCaminhaoPorViagemDTO;
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
            super.STRING_CONEXAO = SPRING_DATASOURCE_URL;
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
        v.setDestino_lat(rs.getFloat("destino_lat"));
        v.setDestino_lng(rs.getFloat("destino_lng"));
        v.setOrigem_lng(rs.getFloat("origem_lng"));
        v.setOrigem_lat(rs.getFloat("origem_lat"));
        
        return v;
    }
    
    @Override
    public void salvar(Viagem v) throws SQLException {
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "INSERT INTO " + super.TABELA + " (caminhao_id ,carga ,endereco_destino ,endereco_origem ,peso_inicial, destino_lat,destino_lng, origem_lat,origem_lng)"
                    + " VALUES('" + v.getCaminhao_id()+ "','" + v.getCarga() + "','" + v.getEndereco_destino()+ "','"
                    + v.getEndereco_origem()+ "'," + v.getPeso_inicial() + "," + v.getDestino_lat() + "," + v.getDestino_lng() + "," + v.getOrigem_lat() + "," + v.getOrigem_lng() + ")";

            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        }
    }
    
    public List<ListaCaminhaoPorViagemDTO> listarPorEmpresa(UUID id) throws SQLException{
        List<ListaCaminhaoPorViagemDTO> caminhoes = new ArrayList<ListaCaminhaoPorViagemDTO>();

        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "select c.id as caminhao_id, v.id as viagem_id, c.chassi , c.modelo , c.placa,v.carga ,v.status, v.endereco_destino,"+ 
                    "v.endereco_origem, v.data_inicial ,v.data_final,v.origem_lat, v.origem_lng, v.destino_lat, v.destino_lng," +
                    "v.peso_inicial , v.peso_final, e.nome as empresa_nome from caminhoes c " +
                         "inner join empresas e on e.id = c.empresa_id " +
                         "inner join viagens v on v.caminhao_id  = c.id " +
                         "where e.id = '" + id + "'";

            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        ListaCaminhaoPorViagemDTO dtoAux = new ListaCaminhaoPorViagemDTO();
                        ListaCaminhaoPorViagemDTO dto = dtoAux.preencheDTO(rs);

                        caminhoes.add(dto);
                    }
                }
            }
        }
        return caminhoes;
    }
}
