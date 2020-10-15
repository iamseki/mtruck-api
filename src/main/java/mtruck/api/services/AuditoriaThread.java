/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.services;

import mtruck.api.daos.DAO;
import mtruck.api.entities.Auditoria;

/**
 *
 * @author GERU\christian.seki
 */
public class AuditoriaThread extends Thread{
    
    private final DAO<Auditoria> auditoriaDAO ;
    private boolean status;
    
    public AuditoriaThread(DAO dao){
        this.auditoriaDAO = dao;
    }
    
    public void salvar(){
        Auditoria a = AuditoriaService.getInstancia().retiraObjAuditoria();
        
        this.auditoriaDAO.salvar(a);
    }

    void setStatus(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
