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
 * @author chseki
 */
public class Viagem {
    private UUID id;
    private UUID caminhao_id;
    private String status;
    private String endereco_origem;
    private String endereco_destino;
    private float peso_inicial;
    private float peso_final;
    private Date data_inicial;
    private Date data_final;

    public Viagem(UUID id, UUID caminhao_id, String status, String endereco_origem, String endereco_destino, float peso_inicial, float peso_final, Date data_inicial, Date data_final) {
        this.id = id;
        this.caminhao_id = caminhao_id;
        this.status = status;
        this.endereco_origem = endereco_origem;
        this.endereco_destino = endereco_destino;
        this.peso_inicial = peso_inicial;
        this.peso_final = peso_final;
        this.data_inicial = data_inicial;
        this.data_final = data_final;
    }

    public Viagem() {
    }

    public UUID getCaminhao_id() {
        return caminhao_id;
    }

    public Date getData_final() {
        return data_final;
    }

    public Date getData_inicial() {
        return data_inicial;
    }

    public String getEndereco_destino() {
        return endereco_destino;
    }

    public String getEndereco_origem() {
        return endereco_origem;
    }

    public UUID getId() {
        return id;
    }

    public float getPeso_final() {
        return peso_final;
    }

    public float getPeso_inicial() {
        return peso_inicial;
    }

    public String getStatus() {
        return status;
    }

    public void setCaminhao_id(UUID caminhao_id) {
        this.caminhao_id = caminhao_id;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public void setData_inicial(Date data_inicial) {
        this.data_inicial = data_inicial;
    }

    public void setEndereco_destino(String endereco_destino) {
        this.endereco_destino = endereco_destino;
    }

    public void setEndereco_origem(String endereco_origem) {
        this.endereco_origem = endereco_origem;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setPeso_final(float peso_final) {
        this.peso_final = peso_final;
    }

    public void setPeso_inicial(float peso_inicial) {
        this.peso_inicial = peso_inicial;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}