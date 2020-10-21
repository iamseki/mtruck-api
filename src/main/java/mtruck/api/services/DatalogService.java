/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.services;

import java.util.List;
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
        Auditoria a = new Auditoria("Inclusão de um Datalog");
        AuditoriaService.getInstancia().adicionaAuditoria(a);

        this.datalogDAO.salvar(d);

        AuditoriaService.getInstancia().ativar();

    }

    public List<Datalog> listar() {
        Auditoria a = new Auditoria("Listagem de Datalog");
        AuditoriaService.getInstancia().adicionaAuditoria(a);
        List<Datalog> logs = this.datalogDAO.listar();

        AuditoriaService.getInstancia().ativar();
        return logs;
    }
}
