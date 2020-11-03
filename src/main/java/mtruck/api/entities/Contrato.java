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
    private Date dataInicial;
    private Date dataFinal;

    public Contrato(UUID id, String tipo, Date dataInicial, Date dataFinal) {
        this.id = id;
        this.tipo = tipo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }
    
    public Contrato(){}

    public UUID getId() {
        return id;
    } 

    public String getTipo() {
        return tipo;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
}