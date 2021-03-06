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
import mtruck.api.entities.Empresa;
/**
 *
 * @author higor
 */
public class EmpresaDAO extends DAO<Empresa> {
    public EmpresaDAO() {
        super.TABELA = "empresas";
        String SPRING_DATASOURCE_URL = System.getenv("SPRING_DATASOURCE_URL");
        if(SPRING_DATASOURCE_URL != null){
            super.STRING_CONEXAO = SPRING_DATASOURCE_URL;
            super.USUARIO = System.getenv("SPRING_DATASOURCE_USERNAME");
            super.SENHA = System.getenv("SPRING_DATASOURCE_PASSWORD");
        }
    }

    @Override
    protected Empresa preencheEntidade(ResultSet rs) throws SQLException {
        Empresa e = new Empresa();

        e.setId(UUID.fromString(rs.getString("id")));
        e.setContrato_id(UUID.fromString(rs.getString("contrato_id")));
        e.setCNPJ(rs.getString("cnpj"));
        e.setSede(rs.getString("sede"));
        e.setNome(rs.getString("nome"));
        e.setData_Cadastro(rs.getTimestamp("data_cadastro"));
        return e;
    }

    @Override
    public void salvar(Empresa e) throws SQLException {
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "INSERT INTO " + super.TABELA + " (contrato_id,cnpj,sede,nome)"
                    + " VALUES('" + e.getContrato_id()+ "','" + e.getCNPJ()+ "','" + e.getSede()+ "','" + e.getNome()+ "')";

            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        }
    }
    
        public void editar(Empresa e) throws SQLException {
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "UPDATE " + super.TABELA
                    + " SET cnpj='" + e.getCNPJ()+ "',nome='" + e.getNome()+ "',sede='" + e.getSede()+ "'"
                    + " WHERE id='" + e.getId().toString() + "'";

            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        }
    }
}
