/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.entities;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author higor
 */
public class Caminhao {
    private UUID id;
    private UUID empresa_id;
    private String modelo;
    private String chassi;
    private String placa;
    private Date data_cadastro;

    public Caminhao(UUID id, UUID empresa_id, String modelo,String chassi, String placa, Date data_cadastro ) {
        this.id = id;
        this.empresa_id = empresa_id;
        this.modelo = modelo;
        this.chassi = chassi;
        this.placa = placa;
        this.data_cadastro = data_cadastro;
    }
    
    public Caminhao(){}

    public UUID getId() {
        return id;
    } 

    public UUID getEmpresa_Id() {
        return empresa_id;
    }

    public String getModelo() {
        return modelo;
    }
    
        public String getChassi() {
        return chassi;
    }

    public String getPlaca() {
        return placa;
    }
    
    public Date getData_Cadastro() {
        return data_cadastro;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    
    public void setEmpresa_id(UUID empresa_id) {
        this.empresa_id = empresa_id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setData_Cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
}
