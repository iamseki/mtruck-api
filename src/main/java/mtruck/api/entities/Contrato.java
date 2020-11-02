/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.entities;

import java.util.UUID;
import java.util.Date;
/**
 *
 * @author higor
 */
public class Contrato {
    private UUID id;
    private String tipo;
    private Date data_inicial;
    private Date data_final;

    public Contrato(UUID id, String tipo, Date data_inicial, Date data_final) {
        this.id = id;
        this.tipo = tipo;
        this.data_inicial = data_inicial;
        this.data_final = data_final;
    }
    
    public Contrato(){}

    public UUID getId() {
        return id;
    } 

    public String getTipo() {
        return tipo;
    }

    public Date getData_Inicial() {
        return data_inicial;
    }

    public Date getData_Final() {
        return data_final;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setData_Inicial(Date data_inicial) {
        this.data_inicial = data_inicial;
    }

    public void setData_Final(Date data_final) {
        this.data_final = data_final;
    }
}