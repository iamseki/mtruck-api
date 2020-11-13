/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import mtruck.api.entities.PerfilUsuario;

/**
 *
 * @author chseki
 */
public class PerfilUsuarioDAO extends DAO<PerfilUsuario> {
    
    public PerfilUsuarioDAO(){
        super.TABELA = "perfil_usuario";
        String SPRING_DATASOURCE_URL = System.getenv("SPRING_DATASOURCE_URL");
        if(SPRING_DATASOURCE_URL != null){
            super.STRING_CONEXAO = SPRING_DATASOURCE_URL;
            super.USUARIO = System.getenv("SPRING_DATASOURCE_USERNAME");
            super.SENHA = System.getenv("SPRING_DATASOURCE_PASSWORD");
        }
    }
    
    @Override
    protected PerfilUsuario preencheEntidade(ResultSet rs) throws SQLException {
        PerfilUsuario pu = new PerfilUsuario();
        
        pu.setId(UUID.fromString(rs.getString("id")));
        pu.setDescricao(rs.getString("descricao"));
        
        return pu;
    }
}
