/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.controllers;

import java.sql.SQLException;
import mtruck.api.daos.CaminhaoDAO;
import mtruck.api.entities.Caminhao;
import mtruck.api.services.CaminhaoService;
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
@RequestMapping("/caminhoes")
@Validated
@RestController
public class CaminhaoController {
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    void cadastrar(@RequestBody Caminhao caminhao) throws SQLException {

        CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
        CaminhaoService svc = new CaminhaoService(caminhaoDAO);
        svc.salvar(caminhao);
    }
}
