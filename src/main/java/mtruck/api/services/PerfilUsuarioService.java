/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mtruck.api.daos.DAO;
import mtruck.api.entities.Auditoria;
import mtruck.api.entities.PerfilUsuario;

/**
 *
 * @author GERU\christian.seki
 */
public class PerfilUsuarioService {

    private final DAO<PerfilUsuario> usuarioPerfilDAO;

    public PerfilUsuarioService(DAO<PerfilUsuario> dao) {
        this.usuarioPerfilDAO = dao;
    }

    public List<PerfilUsuario> listar() {
        List<PerfilUsuario> perfis = new ArrayList<>();
        try {
            Auditoria a = new Auditoria("Listagem de perfil de usuario");
            AuditoriaService.getInstancia().adicionaAuditoria(a);

            perfis = this.usuarioPerfilDAO.listar();

            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return perfis;
    }
}
