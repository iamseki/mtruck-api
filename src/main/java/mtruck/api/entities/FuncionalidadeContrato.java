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
public class FuncionalidadeContrato {
    private UUID funcionalidade_id;
    private UUID contrato_id;

    public FuncionalidadeContrato() {
    }

    public FuncionalidadeContrato(UUID funcionalidade_id, UUID contrato_id) {
        this.funcionalidade_id = funcionalidade_id;
        this.contrato_id = contrato_id;
    }

    public UUID getContrato_id() {
        return contrato_id;
    }

    public UUID getFuncionalidade_id() {
        return funcionalidade_id;
    }

    public void setFuncionalidade_id(UUID funcionalidade_id) {
        this.funcionalidade_id = funcionalidade_id;
    }

    public void setContrato_id(UUID contrato_id) {
        this.contrato_id = contrato_id;
    }
}
