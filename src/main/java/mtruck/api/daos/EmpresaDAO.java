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
    }

    @Override
    protected Empresa preencheEntidade(ResultSet rs) throws SQLException {
        Empresa e = new Empresa();

        e.setId(UUID.fromString(rs.getString("id")));
        e.setId_Contrato(UUID.fromString(rs.getString("id_contrato")));
        e.setCNPJ(rs.getString("cnpj"));
        e.setSede(rs.getString("sede"));
        e.setData_Cadastro(rs.getTimestamp("data_cadastro"));
        return e;
    }

    @Override
    public void salvar(Empresa e) throws SQLException {
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "INSERT INTO " + super.TABELA + " (id_contrato,cnpj,sede,data_cadastro)"
                    + " VALUES('" + e.getId_Contrato()+ "','" + e.getCNPJ()+ "','" + e.getSede()+ "','" + e.getData_Cadastro() + "')";

            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        }
    }
}
