/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.services;


import java.util.concurrent.ConcurrentLinkedQueue;
import mtruck.api.daos.AuditoriaDAO;
import mtruck.api.entities.Auditoria;

/**
 *
 * @author gabriell
 */
public class AuditoriaService {

    ConcurrentLinkedQueue<Auditoria> filaObjAuditoria;
    
    /* Implementação do Singleton */
    private static AuditoriaService instancia;

    private AuditoriaService() {
        filaObjAuditoria = new ConcurrentLinkedQueue<>();
        //filaMensagens = new LinkedList<>();
    }

    public static AuditoriaService getInstancia() {
        if (instancia == null) {
            instancia = new AuditoriaService();
        }
        return instancia;
    }

    /* Fim da implementação do Singleton */
    AuditoriaThread thread;

    public void adicionaAuditoria(Auditoria a) {
        filaObjAuditoria.add(a);
    }

    Auditoria retiraObjAuditoria() {
        Auditoria a = filaObjAuditoria.poll();
        return a;
    }
    
    void ativar(){
        if (thread == null){
            AuditoriaDAO dao = new AuditoriaDAO();
            thread = new AuditoriaThread(dao);
            thread.start();
        }
    }
    
    void desativar(){
        thread.setStatus(false);
        thread = null;
    }
}

