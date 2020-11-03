/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import mtruck.api.entities.FuncionalidadeContrato;

/**
 *
 * @author chseki
 */
public class FuncionalidadeContratoDAO extends DAO<FuncionalidadeContrato> {
    
    public FuncionalidadeContratoDAO(){
        super.TABELA = "funcionlidade_contrato";
    }
    
    @Override
    protected FuncionalidadeContrato preencheEntidade(ResultSet rs) throws SQLException {
        FuncionalidadeContrato fc = new FuncionalidadeContrato();
        
        fc.setContrato_id(UUID.fromString(rs.getString("contrato_id")));
        fc.setFuncionalidade_id(UUID.fromString(rs.getString("funcionalidade_id")));
        
        return fc;
    }
}
