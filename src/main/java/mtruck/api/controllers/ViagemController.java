/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.controllers;

import java.util.List;
import java.util.UUID;
import mtruck.api.daos.ViagemDAO;
import mtruck.api.dtos.ListaCaminhaoPorViagemDTO;
import mtruck.api.entities.Viagem;
import mtruck.api.services.ViagemService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chseki
 */
@RequestMapping("viagens")
@Validated
@RestController
public class ViagemController {

    @GetMapping
    List<Viagem> listar() {
        ViagemDAO vDAO = new ViagemDAO();
        ViagemService svc = new ViagemService(vDAO);

        return svc.listar();
    }

    @GetMapping("/{id}")
    public Viagem pesquisar(@PathVariable UUID id){
        ViagemDAO vDAO = new ViagemDAO();
        ViagemService svc = new ViagemService(vDAO);
        
        return svc.pesquisarComCaminhao(id);
    }

    @GetMapping("empresa/{id}")
    List<ListaCaminhaoPorViagemDTO> listarPorEmpresa(@PathVariable UUID id) {
        ViagemDAO vDAO = new ViagemDAO();
        ViagemService svc = new ViagemService(vDAO);

        return svc.listarCaminhoesPorEmpresaID(id);
    }
    
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    void cadastrar(@RequestBody Viagem v) {
        
        ViagemDAO vDAO = new ViagemDAO();
        ViagemService svc = new ViagemService(vDAO);
        svc.salvar(v);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deletar(@PathVariable UUID id) {
        ViagemDAO vDAO = new ViagemDAO();
        ViagemService svc = new ViagemService(vDAO);
        svc.deletar(id);
    }
}
