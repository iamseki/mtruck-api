/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.controllers;

import java.sql.SQLException;
import mtruck.api.daos.EmpresaDAO;
import mtruck.api.entities.Empresa;
import mtruck.api.services.EmpresaService;
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
@RequestMapping("/empresas")
@Validated
@RestController
public class EmpresaController {

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    void cadastrar(@RequestBody Empresa empresa) throws SQLException {

        EmpresaDAO empresaDAO = new EmpresaDAO();
        EmpresaService svc = new EmpresaService(empresaDAO);
        svc.salvar(empresa);
    }

  
}