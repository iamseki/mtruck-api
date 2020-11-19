/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.controllers;

import java.util.List;
import java.sql.SQLException;
import java.util.UUID;
import mtruck.api.daos.CaminhaoDAO;
import mtruck.api.daos.EmpresaDAO;
import mtruck.api.entities.Caminhao;
import mtruck.api.entities.Empresa;
import mtruck.api.services.CaminhaoService;
import mtruck.api.services.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping
    List<Empresa> listar() {
        EmpresaDAO dao = new EmpresaDAO();
        EmpresaService service = new EmpresaService(dao);
        List<Empresa> empresas = service.listar();

        return empresas;
    }

    @GetMapping("/caminhoes/{empresa_id}")
    List<Caminhao> pesquisar(@PathVariable UUID empresa_id) {
        CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
        CaminhaoService svc = new CaminhaoService(caminhaoDAO);
        List<Caminhao> caminhoes = svc.listar(empresa_id);

        return caminhoes;
    }
}
