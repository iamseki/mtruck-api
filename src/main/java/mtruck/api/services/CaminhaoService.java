/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import mtruck.api.daos.DAO;
import mtruck.api.daos.CaminhaoDAO;
import mtruck.api.entities.Auditoria;
import mtruck.api.entities.Caminhao;

/**
 *
 * @author higor
 */
public class CaminhaoService {
    private final DAO<Caminhao> caminhaoDAO ;
    
    public CaminhaoService(DAO dao){
        this.caminhaoDAO = dao;
    }
    
    public CaminhaoService(){
        this.caminhaoDAO = null;
    };
    
    public void salvar(Caminhao c) throws SQLException{
        
        Auditoria a = new Auditoria("Inclusão de caminhão");
        AuditoriaService.getInstancia().adicionaAuditoria(a);
        
        // Salvar caminhão no banco
        this.caminhaoDAO.salvar(c);
        
        AuditoriaService.getInstancia().ativar();
    }
    
        public List<Caminhao> listar() {
        List<Caminhao> caminhoes = new ArrayList<>();
        try {
            Auditoria a = new Auditoria("Listagem de Datalog");
            AuditoriaService.getInstancia().adicionaAuditoria(a);
            caminhoes = this.caminhaoDAO.listar();
            
            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return caminhoes;
    }
           public List<Caminhao> listar(UUID empresa_id) {
        List<Caminhao> caminhoes = new ArrayList<>();
        try {
            Auditoria a = new Auditoria("Listagem de Datalog");
            AuditoriaService.getInstancia().adicionaAuditoria(a);
            CaminhaoDAO camDao = new CaminhaoDAO();
            
            caminhoes = camDao.listaPorEmpresaId(empresa_id);
            
            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return caminhoes;
    }
}
