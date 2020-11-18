/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.services;

import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import mtruck.api.daos.DAO;
import mtruck.api.daos.PerfilUsuarioDAO;
import mtruck.api.daos.UsuarioDAO;
import mtruck.api.dtos.ResponseLoginDTO;
import mtruck.api.entities.Auditoria;
import mtruck.api.entities.PerfilUsuario;
import mtruck.api.entities.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author GERU\christian.seki
 */
public class UsuarioService {

    private final DAO<Usuario> usuarioDAO;

    public UsuarioService(DAO dao) {
        this.usuarioDAO = dao;
    }

    public UsuarioService() {
        this.usuarioDAO = null;
    }

    ;
    
    public void salvar(Usuario u) {

        Auditoria a = new Auditoria("Inclusão de usuário");
        AuditoriaService.getInstancia().adicionaAuditoria(a);

        // Salvar usuário no banco
        // blabla e auditar se der certo
        AuditoriaService.getInstancia().ativar();
    }

    public ResponseLoginDTO login(String email, String senha) throws SQLException {

        Usuario usuario = ((UsuarioDAO) this.usuarioDAO).procuraUsusarioPorUserESenha(email, senha);

        UUID userId = usuario.getId();

        if (userId != null) {
            PerfilUsuarioDAO perfilDao = new PerfilUsuarioDAO();
            PerfilUsuario perfil = perfilDao.pesquisar(usuario.getPerfil_id());

            return new ResponseLoginDTO(usuario.getNome(), usuario.getNome(), usuario.getEmail(), usuario.getEmpresa_id());
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Usuário e senha Invalidos.");
        }
    }

    public void editar(Usuario u) {
        try {
            Auditoria a = new Auditoria("Listagem de Datalog");
            AuditoriaService.getInstancia().adicionaAuditoria(a);

            ((UsuarioDAO) this.usuarioDAO).editar(u);

            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
