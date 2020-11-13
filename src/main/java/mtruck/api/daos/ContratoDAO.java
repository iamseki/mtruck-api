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
import mtruck.api.entities.Contrato;

/**
 *
 * @author higor
 */
public class ContratoDAO extends DAO<Contrato> {

    public ContratoDAO() {
        super.TABELA = "contratos";
        String SPRING_DATASOURCE_URL = System.getenv("SPRING_DATASOURCE_URL");
        if(SPRING_DATASOURCE_URL != null){
            super.STRING_CONEXAO = SPRING_DATASOURCE_URL;
            super.USUARIO = System.getenv("SPRING_DATASOURCE_USERNAME");
            super.SENHA = System.getenv("SPRING_DATASOURCE_PASSWORD");
        }
    }

    @Override
    protected Contrato preencheEntidade(ResultSet rs) throws SQLException {
        Contrato c = new Contrato();

        c.setId(UUID.fromString(rs.getString("id")));
        c.setTipo(rs.getString("tipo"));
        c.setDataInicial(rs.getTimestamp("data_inicial"));
        c.setDataFinal(rs.getTimestamp("data_final"));
        return c;
    }

    @Override
    public void salvar(Contrato c) throws SQLException {
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "INSERT INTO " + super.TABELA + " (tipo,data_inicial,data_final)"
                    + " VALUES('" + c.getTipo() + "','" + c.getDataInicial() + "','" + c.getDataFinal() + "')";

            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        }
    }
}