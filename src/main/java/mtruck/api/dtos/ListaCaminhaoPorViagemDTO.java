/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.dtos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author chseki
 */
public class ListaCaminhaoPorViagemDTO {
    
    private UUID caminhao_id;
    private String empresa_nome;
    private String chassi;
    private String modelo;
    private String placa;
    private String carga;
    private String status;
    private String endereco_destino;
    private String endereco_origem;
    private Date data_inicial;
    private Date data_final;
    private float peso_inicial;
    private float peso_final;
    
    public ListaCaminhaoPorViagemDTO(){}
    
    public ListaCaminhaoPorViagemDTO preencheDTO(ResultSet rs) throws SQLException {
       
        
        ListaCaminhaoPorViagemDTO dto = new ListaCaminhaoPorViagemDTO();
        
        dto.setCaminhao_id(UUID.fromString(rs.getString("caminhao_id")));
        dto.setModelo(rs.getString("modelo"));
        dto.setCarga(rs.getString("carga"));
        dto.setChassi(rs.getString("chassi"));
        dto.setStatus(rs.getString("status"));
        dto.setPlaca(rs.getString("placa"));
        dto.setEndereco_destino(rs.getString("endereco_destino"));
        dto.setEndereco_origem(rs.getString("endereco_origem"));
        dto.setPeso_final(rs.getFloat("peso_final"));
        dto.setPeso_inicial(rs.getFloat("peso_inicial"));
        dto.setData_final(rs.getTimestamp("data_final"));
        dto.setData_inicial(rs.getTimestamp("data_inicial"));
        
        
        return dto;
    }

    public UUID getCaminhao_id() {
        return caminhao_id;
    }

    public String getCarga() {
        return carga;
    }

    public String getChassi() {
        return chassi;
    }

    public Date getData_final() {
        return data_final;
    }

    public Date getData_inicial() {
        return data_inicial;
    }

    public String getEmpresa_nome() {
        return empresa_nome;
    }

    public String getEndereco_destino() {
        return endereco_destino;
    }

    public String getEndereco_origem() {
        return endereco_origem;
    }

    public String getModelo() {
        return modelo;
    }

    public float getPeso_final() {
        return peso_final;
    }

    public float getPeso_inicial() {
        return peso_inicial;
    }

    public String getPlaca() {
        return placa;
    }

    public String getStatus() {
        return status;
    }

    public void setCaminhao_id(UUID caminhao_id) {
        this.caminhao_id = caminhao_id;
    }

    public void setCarga(String carga) {
        this.carga = carga;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public void setData_inicial(Date data_inicial) {
        this.data_inicial = data_inicial;
    }

    public void setEmpresa_nome(String empresa_nome) {
        this.empresa_nome = empresa_nome;
    }

    public void setEndereco_destino(String endereco_destino) {
        this.endereco_destino = endereco_destino;
    }

    public void setEndereco_origem(String endereco_origem) {
        this.endereco_origem = endereco_origem;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPeso_final(float peso_final) {
        this.peso_final = peso_final;
    }

    public void setPeso_inicial(float peso_inicial) {
        this.peso_inicial = peso_inicial;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}