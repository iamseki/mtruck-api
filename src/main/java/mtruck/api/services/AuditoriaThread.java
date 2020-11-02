/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.services;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    @Override
    public void run() {
        setStatus(true);
        while (status) {
            try {
                Auditoria a = AuditoriaService.getInstancia().retiraObjAuditoria();
                if(a == null) {
                    AuditoriaService.getInstancia().desativar();
                    break;
                }

                try {
                    this.auditoriaDAO.salvar(a);
                } catch (SQLException ex) {
                    Logger.getLogger(AuditoriaThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(AuditoriaThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setStatus(boolean value) {
        status = value;
    }
}
