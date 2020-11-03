/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.services;

import java.sql.SQLException;
import mtruck.api.daos.DAO;
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
}
