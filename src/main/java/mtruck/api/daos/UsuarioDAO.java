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
import mtruck.api.entities.Usuario;

/**
 *
 * @author GERU\christian.seki
 */
public class UsuarioDAO extends DAO<Usuario> {

    public UsuarioDAO() {
        super.TABELA = "usuarios";
        String SPRING_DATASOURCE_URL = System.getenv("SPRING_DATASOURCE_URL");
        if (SPRING_DATASOURCE_URL != null) {
            super.STRING_CONEXAO = SPRING_DATASOURCE_URL;
            super.USUARIO = System.getenv("SPRING_DATASOURCE_USERNAME");
            super.SENHA = System.getenv("SPRING_DATASOURCE_PASSWORD");
        }
    }

    @Override
    protected Usuario preencheEntidade(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();

        u.setId(UUID.fromString(rs.getString("id")));
        u.setCPF(rs.getString("cpf"));
        u.setEmail(rs.getString("email"));
        u.setNome(rs.getString("nome"));
        u.setSenha(rs.getString("senha"));
        u.setEmpresa_id(UUID.fromString(rs.getString("empresa_id")));
        u.setPerfil_id(UUID.fromString(rs.getString("perfil_id")));

        return u;
    }

    @Override
    public void salvar(Usuario u) throws SQLException {
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "INSERT INTO " + super.TABELA + " (nome,cpf,email,senha,empresa_id,perfil_id)"
                    + " VALUES('" + u.getNome() + "','" + u.getCPF() + "','" + u.getEmail() + "','"
                    + u.getSenha() + "','" + u.getEmpresa_id() + "','" + u.getPerfil_id() + "')";

            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        }
    }

    public Usuario procuraUsusarioPorUserESenha(String email, String senha) throws SQLException {
        Usuario u = new Usuario();
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "SELECT * FROM " + TABELA + " WHERE email='" + email + "'" + " AND senha= '" + senha + "'";

            System.out.println("[Pesquisar] - SQL: " + SQL);
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        u = preencheEntidade(rs);
                    }
                }
            }
        }
        return u;
    }

    public void editar(Usuario u) throws SQLException {
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "UPDATE " + super.TABELA
                    + " SET nome='" + u.getNome() + "',cpf='" + u.getCPF() + "',email='" + u.getEmail() + "'" + "',senha='" + u.getSenha() + "'"
                    + " WHERE id='" + u.getId().toString() + "'";

            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        }
    }

    public List<Usuario> listarPorEmpresaID(UUID id) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList();

        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "SELECT * FROM " + TABELA + " WHERE empresa_id='" + id.toString() + "'";
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Usuario u = this.preencheEntidade(rs);
                        usuarios.add(u);
                    }
                }
            }
        }
        return usuarios;
    }
}
