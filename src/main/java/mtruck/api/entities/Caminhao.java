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
    private String carga;
    private String placa;
    private Date data_cadastro;

    public Caminhao(UUID id, UUID empresa_id, String carga, String placa, Date data_cadastro ) {
        this.id = id;
        this.empresa_id = empresa_id;
        this.carga = carga;
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

    public String getCarga() {
        return carga;
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
    
    public void setEmpresa_Id(UUID empresa_id) {
        this.empresa_id = empresa_id;
    }

    public void setCarga(String carga) {
        this.carga = carga;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setData_Cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
}
