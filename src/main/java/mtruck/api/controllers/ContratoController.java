/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mtruck.api.controllers;
import java.sql.SQLException;
import mtruck.api.daos.ContratoDAO;
import mtruck.api.entities.Contrato;
import mtruck.api.services.ContratoService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author higor
 */
@RequestMapping("/contratos")
@Validated
@RestController
public class ContratoController {

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    void cadastrar(@RequestBody Contrato contrato) throws SQLException {

        ContratoDAO contratoDAO = new ContratoDAO();
        ContratoService svc = new ContratoService(contratoDAO);
        svc.salvar(contrato);
    }

  
}