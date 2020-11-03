/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.services;

import java.sql.SQLException;
import mtruck.api.daos.DAO;
import mtruck.api.entities.Auditoria;
import mtruck.api.entities.Empresa;
/**
 *
 * @author higor
 */
public class EmpresaService {
    
    private final DAO<Empresa> empresaDAO ;
    
    public EmpresaService(DAO dao){
        this.empresaDAO = dao;
    }
    
    public EmpresaService(){
        this.empresaDAO = null;
    };
    
    public void salvar(Empresa e) throws SQLException{
        
        Auditoria a = new Auditoria("Inclusão de empresa");
        AuditoriaService.getInstancia().adicionaAuditoria(a);
        
        // Salvar empresa no banco
        this.empresaDAO.salvar(e);
        
        AuditoriaService.getInstancia().ativar();
    }
}
