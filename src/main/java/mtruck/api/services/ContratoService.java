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
import mtruck.api.entities.Contrato;

/**
 *
 * @author GERU\christian.seki
 */
public class ContratoService {

    private final DAO<Contrato> contratoDAO;

    public ContratoService(DAO dao) {
        this.contratoDAO = dao;
    }

    public ContratoService() {
        this.contratoDAO = null;
    }

    ;
    
    public void salvar(Contrato c) throws SQLException {

        Auditoria a = new Auditoria("Inclusão de contrato");
        AuditoriaService.getInstancia().adicionaAuditoria(a);

        //salvar no banco
        this.contratoDAO.salvar(c);

        AuditoriaService.getInstancia().ativar();
    }

    public List<Contrato> listar() {
        List<Contrato> contratos = new ArrayList<>();
        try {
            Auditoria a = new Auditoria("Listagem de Empresas");
            AuditoriaService.getInstancia().adicionaAuditoria(a);

            contratos = this.contratoDAO.listar();

            AuditoriaService.getInstancia().ativar();
        } catch (SQLException ex) {
            Logger.getLogger(DatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return contratos;
    }
    
    public void editar(Contrato c){
        
    }
}
