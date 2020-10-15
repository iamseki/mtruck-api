/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.services;

import mtruck.api.daos.DAO;
import mtruck.api.entities.Auditoria;
import mtruck.api.entities.User;

/**
 *
 * @author GERU\christian.seki
 */
public class UsuarioService {
    
    private final DAO<User> usuarioDAO ;
    
    public UsuarioService(DAO dao){
        this.usuarioDAO = dao;
    }
    
    public UsuarioService(){
        this.usuarioDAO = null;
    };
    
    public void salvar(User u){
        
        Auditoria a = new Auditoria("Inclusão de usuário");
        AuditoriaService.getInstancia().adicionaAuditoria(a);
        
        // Salvar usuário no banco
        // blabla e auditar se der certo
        
        AuditoriaService.getInstancia().ativar();
    }
}
