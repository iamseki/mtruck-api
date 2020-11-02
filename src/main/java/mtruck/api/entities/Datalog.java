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
 * @author GERU\christian.seki
 */
public class Datalog {
    private UUID id;
    private UUID viagem_id;
    private float peso_atual;
    private String latitude;
    private String longitude;
    private Date data;
    
    public Datalog(){}

    public Datalog(UUID id, UUID viagem_id, float peso_atual, String latitude, String longitude, Date data) {
        this.id = id;
        this.viagem_id = viagem_id;
        this.peso_atual = peso_atual;
        this.latitude = latitude;
        this.longitude = longitude;
        this.data = data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setPeso_atual(float peso_atual) {
        this.peso_atual = peso_atual;
    }

    public Date getData() {
        return data;
    }

    public UUID getId() {
        return id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public float getPeso_atual() {
        return peso_atual;
    }

    public void setViagem_id(UUID viagem_id) {
        this.viagem_id = viagem_id;
    }

    public UUID getViagem_id() {
        return viagem_id;
    }      
}
