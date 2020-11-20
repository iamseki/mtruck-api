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
import mtruck.api.entities.Auditoria;

/**
 *
 * @author GERU\christian.seki
 */
public class AuditoriaDAO extends DAO<Auditoria> {

    public AuditoriaDAO() {
        super.TABELA = "auditoria";
        String SPRING_DATASOURCE_URL = System.getenv("SPRING_DATASOURCE_URL");
        if(SPRING_DATASOURCE_URL != null){
            super.STRING_CONEXAO = SPRING_DATASOURCE_URL;
            super.USUARIO = System.getenv("SPRING_DATASOURCE_USERNAME");
            super.SENHA = System.getenv("SPRING_DATASOURCE_PASSWORD");
        }
    }

    @Override
    public void salvar(Auditoria a) throws SQLException {
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "INSERT INTO " +super.TABELA+ " (descricao)"
                    + " VALUES('" + a.getDescricao() + "')";

            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        }
    }

    @Override
    protected Auditoria preencheEntidade(ResultSet rs) throws SQLException {
        Auditoria a = new Auditoria();

        a.setId(UUID.fromString(rs.getString("id")));
        a.setDescricao(rs.getString("descricao"));
        a.setData_criacao(rs.getTimestamp("data_criacao"));

        return a;
    }
}
