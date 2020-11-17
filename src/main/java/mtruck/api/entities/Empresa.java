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
    private UUID contrato_id;
    private String cnpj;
    private String sede;
    private String nome;
    private Date data_cadastro;

    public Empresa(UUID id, UUID contrato_id, String cnpj, String sede,String nome, Date data_cadastro ) {
        this.id = id;
        this.contrato_id = contrato_id;
        this.cnpj = cnpj;
        this.sede = sede;
        this.data_cadastro = data_cadastro;
        this.nome = nome;
    }
    
    public Empresa(){}

    public UUID getId() {
        return id;
    } 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     
    public UUID getContrato_id() {
        return contrato_id;
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
    
    public void setContrato_id(UUID contrato_id) {
        this.contrato_id = contrato_id;
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
