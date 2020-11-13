/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import mtruck.api.entities.Funcionalidade;

/**
 *
 * @author chseki
 */
public class FuncionalidadeDAO extends DAO<Funcionalidade> {
    
    public FuncionalidadeDAO(){
        super.TABELA = "funcionalidades";
        String SPRING_DATASOURCE_URL = System.getenv("SPRING_DATASOURCE_URL");
        if(SPRING_DATASOURCE_URL != null){
            super.STRING_CONEXAO = SPRING_DATASOURCE_URL;
            super.USUARIO = System.getenv("SPRING_DATASOURCE_USERNAME");
            super.SENHA = System.getenv("SPRING_DATASOURCE_PASSWORD");
        }
    }
    
    @Override
    protected Funcionalidade preencheEntidade(ResultSet rs) throws SQLException {
        Funcionalidade f = new Funcionalidade();
        
        f.setId(UUID.fromString(rs.getString("id")));
        f.setDescricao(rs.getString("descricao"));
        
        return f;
    }
}
