/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.services;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import mtruck.api.entities.Viagem;
import mtruck.api.daos.DAO;
import mtruck.api.daos.ViagemDAO;
import mtruck.api.dtos.ListaCaminhaoPorViagemDTO;
import mtruck.api.entities.Auditoria;

/**
 *
 * @author chseki
 */
public class ViagemService {

    private final DAO<Viagem> viagemDao;

    public ViagemService(DAO<Viagem> dao) {
        this.viagemDao = dao;
    }

    public List<Viagem> listar() {
        List<Viagem> viagens = null;
        try {
            Auditoria a = new Auditoria("Inclusão de usuário");
            AuditoriaService.getInstancia().adicionaAuditoria(a);

            viagens = this.viagemDao.listar();

            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return viagens;
    }

    public List<ListaCaminhaoPorViagemDTO> listarCaminhoesPorEmpresaID(UUID id) {
        List<ListaCaminhaoPorViagemDTO> caminhoes = null;
        try {
            Auditoria a = new Auditoria("Inclusão de usuário");
            AuditoriaService.getInstancia().adicionaAuditoria(a);
            
            System.out.println("Entrei Lista por viagem DTO");
            caminhoes = ((ViagemDAO) this.viagemDao).listarPorEmpresa(id);

            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return caminhoes;
    }

    public void salvar(Viagem v) {
        try {
            Auditoria a = new Auditoria("Inclusão de viagem");
            AuditoriaService.getInstancia().adicionaAuditoria(a);

            this.viagemDao.salvar(v);

            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Viagem pesquisar(UUID id) {
        Viagem v = null;
        try {
            Auditoria a = new Auditoria("Pesquisa de usuário");
            AuditoriaService.getInstancia().adicionaAuditoria(a);

            v = ((ViagemDAO) this.viagemDao).pesquisar(id);

            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    public Viagem pesquisarComCaminhao(UUID id) {
        Viagem v = null;
        try {
            Auditoria a = new Auditoria("Pesquisa de usuário");
            AuditoriaService.getInstancia().adicionaAuditoria(a);

            v = ((ViagemDAO) this.viagemDao).pesquisarComCaminhao(id);

            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    public void deletar(UUID id){
        try {
            Auditoria a = new Auditoria("Remoção de viagem");
            AuditoriaService.getInstancia().adicionaAuditoria(a);

            this.viagemDao.deletar(id);

            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
