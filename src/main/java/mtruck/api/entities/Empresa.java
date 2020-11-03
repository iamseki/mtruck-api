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
public class Empresa {
    private UUID id;
    private UUID id_contrato;
    private String cnpj;
    private String sede;
    private Date data_cadastro;

    public Empresa(UUID id, UUID id_contrato, String cnpj, String sede, Date data_cadastro ) {
        this.id = id;
        this.id_contrato = id_contrato;
        this.cnpj = cnpj;
        this.sede = sede;
        this.data_cadastro = data_cadastro;
    }
    
    public Empresa(){}

    public UUID getId() {
        return id;
    } 

    public UUID getId_Contrato() {
        return id_contrato;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public String getSede() {
        return sede;
    }
    
    public Date getData_Cadastro() {
        return data_cadastro;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    
    public void setId_Contrato(UUID id_contrato) {
        this.id_contrato = id_contrato;
    }

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public void setData_Cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
}
