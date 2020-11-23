/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import mtruck.api.daos.CaminhaoDAO;
import mtruck.api.entities.Caminhao;
import mtruck.api.services.CaminhaoService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    
    
    @GetMapping
    List<Caminhao> listar() {
        CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
        CaminhaoService svc = new CaminhaoService(caminhaoDAO);
        List<Caminhao> caminhoes = svc.listar();

        return caminhoes;
    }
    
    @GetMapping("/{id}")
    Caminhao pesquisar(@PathVariable UUID id) {
        CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
        CaminhaoService svc = new CaminhaoService(caminhaoDAO);
        return svc.pesquisar(id);
    }
    
    @PatchMapping("/{id}")
    void editar(@PathVariable UUID id, @RequestBody Caminhao c) {
        CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
        CaminhaoService svc = new CaminhaoService(caminhaoDAO);
        c.setId(id);
        svc.editar(c);
    } 

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deletar(@PathVariable UUID id) {
        CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
        CaminhaoService svc = new CaminhaoService(caminhaoDAO);
        svc.deletar(id);
    }
}
