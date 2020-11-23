/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.services;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.UUID;
import mtruck.api.daos.DAO;
import mtruck.api.daos.EmpresaDAO;
import mtruck.api.entities.Auditoria;
import mtruck.api.entities.Empresa;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author higor
 */
public class EmpresaService {

    private final DAO<Empresa> empresaDAO;

    public EmpresaService(DAO dao) {
        this.empresaDAO = dao;
    }

    public void salvar(Empresa e) throws SQLException {

        Auditoria a = new Auditoria("Inclusão de empresa");
        AuditoriaService.getInstancia().adicionaAuditoria(a);

        // Salvar empresa no banco
        this.empresaDAO.salvar(e);

        AuditoriaService.getInstancia().ativar();
    }

    public List<Empresa> listar() {
        List<Empresa> empresas = new ArrayList<>();
        try {
            Auditoria a = new Auditoria("Listagem de Empresas");
            AuditoriaService.getInstancia().adicionaAuditoria(a);

            empresas = this.empresaDAO.listar();

            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return empresas;
    }

    public void editar(Empresa e) {
        try {
            Auditoria a = new Auditoria("Listagem de Empresas");
            AuditoriaService.getInstancia().adicionaAuditoria(a);

            ((EmpresaDAO) this.empresaDAO).editar(e);

            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Empresa pesquisar(UUID id) {
        Empresa e = null;
        try {
            Auditoria a = new Auditoria("Pesquisa de usuário");
            AuditoriaService.getInstancia().adicionaAuditoria(a);

            e = this.empresaDAO.pesquisar(id);

            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    public void deletar(UUID id){
        try {
            Auditoria a = new Auditoria("Remoção de usuario");
            AuditoriaService.getInstancia().adicionaAuditoria(a);

            this.empresaDAO.deletar(id);

            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
