/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.entities;

import java.util.UUID;

/**
 *
 * @author chseki
 */
public class PerfilUsuario {
    private UUID id;
    private String descricao;

    public PerfilUsuario(UUID id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public PerfilUsuario() {
    }

    public String getDescricao() {
        return descricao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }   
}
