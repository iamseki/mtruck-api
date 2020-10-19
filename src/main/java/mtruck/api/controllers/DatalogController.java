/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.controllers;

import mtruck.api.daos.DatalogDAO;
import mtruck.api.entities.Datalog;
import mtruck.api.services.DatalogService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GERU\christian.seki
 */
@RequestMapping("/datalog")
@RestController
public class DatalogController {
    
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    void salvar(@RequestBody Datalog datalog) {
           DatalogDAO dao = new DatalogDAO();
           DatalogService service = new DatalogService(dao);
           
           service.salvar(datalog);
    }
}
