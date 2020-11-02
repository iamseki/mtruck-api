/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.services;

import java.sql.SQLException;
import mtruck.api.daos.DAO;
import mtruck.api.entities.Auditoria;
import mtruck.api.entities.Contrato;

/**
 *
 * @author GERU\christian.seki
 */
public class ContratoService {
    
    private final DAO<Contrato> contratoDAO ;
    
    public ContratoService(DAO dao){
        this.contratoDAO = dao;
    }
    
    public ContratoService(){
        this.contratoDAO = null;
    };
    
    public void salvar(Contrato c) throws SQLException{
        
        Auditoria a = new Auditoria("Inclusão de contrato");
        AuditoriaService.getInstancia().adicionaAuditoria(a);
        
        //salvar no banco
        this.contratoDAO.salvar(c);

        AuditoriaService.getInstancia().ativar();
    }
}