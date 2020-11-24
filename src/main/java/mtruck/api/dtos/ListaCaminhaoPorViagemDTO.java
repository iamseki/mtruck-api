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
    private UUID viagem_id;
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
    private float destino_lat;
    private float destino_lng;
    private float origem_lat;
    private float origem_lng;
    
    public ListaCaminhaoPorViagemDTO(){}
    
    public ListaCaminhaoPorViagemDTO preencheDTO(ResultSet rs) throws SQLException {
       
        
        ListaCaminhaoPorViagemDTO dto = new ListaCaminhaoPorViagemDTO();
        
        dto.setCaminhao_id(UUID.fromString(rs.getString("caminhao_id")));
        dto.setViagem_id(UUID.fromString(rs.getString("viagem_id")));
        dto.setModelo(rs.getString("modelo"));
        dto.setCarga(rs.getString("carga"));
        dto.setChassi(rs.getString("chassi"));
        dto.setStatus(rs.getString("status"));
        dto.setPlaca(rs.getString("placa"));
        dto.setEndereco_destino(rs.getString("endereco_destino"));
        dto.setEndereco_origem(rs.getString("endereco_origem"));
        dto.setPeso_final(rs.getFloat("peso_final"));
        dto.setPeso_inicial(rs.getFloat("peso_inicial"));
        dto.setDestino_lat(rs.getFloat("destino_lat"));
        dto.setDestino_lng(rs.getFloat("destino_lng"));
        dto.setOrigem_lng(rs.getFloat("origem_lng"));
        dto.setOrigem_lat(rs.getFloat("origem_lat"));
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

    public UUID getViagem_id() {
        return viagem_id;
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

    public float getDestino_lat() {
        return destino_lat;
    }

    public float getDestino_lng() {
        return destino_lng;
    }

    public float getOrigem_lat() {
        return origem_lat;
    }

    public float getOrigem_lng() {
        return origem_lng;
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

    public void setViagem_id(UUID viagem_id) {
        this.viagem_id = viagem_id;
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

    public void setDestino_lat(float destino_lat) {
        this.destino_lat = destino_lat;
    }
    public void setDestino_lng(float destino_lng) {
        this.destino_lng = destino_lng;
    }

    public void setOrigem_lat(float origem_lat) {
        this.origem_lat = origem_lat;
    }

    public void setOrigem_lng(float origem_lng) {
        this.origem_lng = origem_lng;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
