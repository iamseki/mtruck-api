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
import java.util.logging.Level;
import java.util.logging.Logger;
import mtruck.api.entities.Auditoria;
import mtruck.api.entities.Usuario;

/**
 *
 * @author GERU\christian.seki
 */
public class UsuarioDAO implements DAO<Usuario> {

    private final String STRING_CONEXAO = "jdbc:postgresql://localhost/lp2";
    private final String USUARIO = "postgres";
    private final String SENHA = "admin";
    private final String TABELA = "usuarios";

    @Override
    public List<Usuario> listar() {
        ArrayList<Usuario> usuarios = new ArrayList();

        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "SELECT * FROM " + TABELA;
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Usuario u = this.preencheUsuario(rs);
                        usuarios.add(u);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuditoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    private Usuario preencheUsuario(ResultSet rs) {
        Usuario u = new Usuario();

        try {
            u.setId(UUID.fromString(rs.getString("id")));
            u.setCPF(rs.getString("cpf"));
            u.setEmail(rs.getString("email"));
            u.setNome(rs.getString("nome"));
            u.setSenha(rs.getString("senha"));
            u.setEmpresa_id(UUID.fromString(rs.getString("empresa_id")));
            u.setPerfil_id(UUID.fromString(rs.getString("perfil_id")));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return u;
    }

    @Override
    public void salvar(Usuario u) {
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "INSERT INTO usuarios (nome,cpf,email,senha,empresa_id,perfil_id)"
                    + " VALUES('" + u.getNome() + "','" + u.getCPF() + "','" + u.getEmail() + "','" 
                    + u.getSenha() + "','" + u.getEmpresa_id() + "','" + u.getPerfil_id() + "')";

            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuditoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Usuario pesquisar(UUID id) {
        Usuario u = new Usuario();

        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "SELECT * FROM " + TABELA + " WHERE ID='" + id + "'";

            System.out.println("[Pesquisar] - SQL: " + SQL);
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        u = this.preencheUsuario(rs);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
}

