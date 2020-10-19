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
public class Usuario {
    private UUID id;
    private UUID perfil_id;
    private UUID empresa_id;
    private String nome;
    private String CPF;
    private String email;
    private String senha;

    public Usuario(UUID id, UUID perfil_id, UUID empresa_id, String nome, String CPF, String email, String senha) {
        this.id = id;
        this.perfil_id = perfil_id;
        this.empresa_id = empresa_id;
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.senha = senha;
    }
    
    public Usuario(){}
    

    public String getCPF() {
        return CPF;
    }

    public String getEmail() {
        return email;
    }

    public UUID getEmpresa_id() {
        return empresa_id;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public UUID getPerfil_id() {
        return perfil_id;
    }

    public String getSenha() {
        return senha;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmpresa_id(UUID empresa_id) {
        this.empresa_id = empresa_id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPerfil_id(UUID perfil_id) {
        this.perfil_id = perfil_id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
