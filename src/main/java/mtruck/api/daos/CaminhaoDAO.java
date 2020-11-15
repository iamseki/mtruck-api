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
import mtruck.api.entities.Caminhao;

/**
 *
 * @author higor
 */
public class CaminhaoDAO extends DAO<Caminhao>{
    public CaminhaoDAO() {
        super.TABELA = "caminhoes";
        String SPRING_DATASOURCE_URL = System.getenv("SPRING_DATASOURCE_URL");
        if(SPRING_DATASOURCE_URL != null){
            super.STRING_CONEXAO = SPRING_DATASOURCE_URL;
            super.USUARIO = System.getenv("SPRING_DATASOURCE_USERNAME");
            super.SENHA = System.getenv("SPRING_DATASOURCE_PASSWORD");
        }
    }

    @Override
    protected Caminhao preencheEntidade(ResultSet rs) throws SQLException {
        Caminhao c = new Caminhao();

        c.setId(UUID.fromString(rs.getString("id")));
        c.setEmpresa_id(UUID.fromString(rs.getString("empresa_id")));
        c.setModelo(rs.getString("modelo"));
        c.setChassi(rs.getString("chassi"));
        c.setPlaca(rs.getString("placa"));
        c.setData_Cadastro(rs.getTimestamp("data_cadastro"));
        return c;
    }

    @Override
    public void salvar(Caminhao c) throws SQLException {
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "INSERT INTO "+ super.TABELA +" (empresa_id,modelo,chassi,placa)"
                    + " VALUES('" + c.getEmpresa_Id()+ "','" + c.getModelo()+ "','" + c.getChassi() + "','" + c.getPlaca()+"')";

            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        }
    }
    
     public List<Caminhao> listaPorEmpresaId(UUID empresa_id) throws SQLException{
       ArrayList<Caminhao> caminhoes = new ArrayList();
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "SELECT * FROM " + TABELA + " WHERE empresa_id='" + empresa_id.toString() +"'";

            System.out.println("[Pesquisar] - SQL: " + SQL);
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Caminhao c = this.preencheEntidade(rs);
                        caminhoes.add(c);
                    }
                }
            }
        }
        return caminhoes;
    }
     
    public void editar(Caminhao c) throws SQLException{
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "UPDATE "+ super.TABELA 
                    + " SET modelo='"+c.getModelo()+ "',chassi='" + c.getChassi() + "',placa='"+ c.getPlaca()+"'"
                    + " WHERE id='"+c.getId().toString()+"'";

            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        }
    }
}
