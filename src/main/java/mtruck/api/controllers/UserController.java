/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mtruck.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import mtruck.api.entities.Usuario;
import mtruck.api.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chseki
 */
@RequestMapping("/usuarios")
@Validated
@RestController
public class UserController {

    @GetMapping
    List<Usuario> listar() {
        List<Usuario> users = new ArrayList<>();

        return users;
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    void cadastrar(@RequestBody Usuario user) {

     //   UsuarioService svc = new UsuarioService();
     //   System.out.println(user.getNome());
     //   svc.salvar(user);
    }

    @GetMapping("/{id}")
    Usuario pesquisar(@PathVariable UUID id) {
        Usuario user = new Usuario();

        return user;
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void editar(@RequestBody Usuario user, @PathVariable UUID id) {

    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deletar(@PathVariable UUID id) {

    }
}
