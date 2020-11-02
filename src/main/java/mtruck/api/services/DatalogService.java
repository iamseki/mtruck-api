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
import mtruck.api.entities.Datalog;

/**
 *
 * @author GERU\christian.seki
 */
public class DatalogService {

    private final DAO<Datalog> datalogDAO;

    public DatalogService(DAO dao) {
        this.datalogDAO = dao;
    }

    public void salvar(Datalog d) {
        try {
            Auditoria a = new Auditoria("Inclusão de um Datalog");
            AuditoriaService.getInstancia().adicionaAuditoria(a);
            
            this.datalogDAO.salvar(d);
            
            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Datalog> listar() {
        List<Datalog> logs = new ArrayList<>();
        try {
            Auditoria a = new Auditoria("Listagem de Datalog");
            AuditoriaService.getInstancia().adicionaAuditoria(a);
            logs = this.datalogDAO.listar();
            
            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logs;
    }
}
