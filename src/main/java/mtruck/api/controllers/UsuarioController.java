/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import mtruck.api.daos.PerfilUsuarioDAO;
import mtruck.api.daos.UsuarioDAO;
import mtruck.api.dtos.ResponseLoginDTO;
import mtruck.api.entities.PerfilUsuario;
import mtruck.api.entities.Usuario;
import mtruck.api.services.PerfilUsuarioService;
import mtruck.api.services.UsuarioService;
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
@RequestMapping("/usuarios")
@Validated
@RestController
public class UsuarioController {

    @GetMapping
    List<Usuario> listar() {
        List<Usuario> users = new ArrayList<>();

        return users;
    }

    @GetMapping("perfil")
    List<PerfilUsuario> listarPerfis() {
        PerfilUsuarioDAO dao = new PerfilUsuarioDAO();
        PerfilUsuarioService svc = new PerfilUsuarioService(dao);
        return svc.listar();
    }

    @GetMapping("empresa/{id}")
    List<Usuario> listarUsuarioPorEmpresaID(@PathVariable UUID id) {
        UsuarioDAO dao = new UsuarioDAO();
        UsuarioService svc = new UsuarioService(dao);
        return svc.listarPorEmpresaID(id);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    void cadastrar(@RequestBody Usuario user) {
        
        UsuarioDAO uDAO = new UsuarioDAO();
        UsuarioService svc = new UsuarioService(uDAO);

        svc.salvar(user);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/login")
    ResponseLoginDTO Login(@RequestBody Usuario user) throws SQLException {
        UsuarioDAO uDAO = new UsuarioDAO();
        UsuarioService u = new UsuarioService(uDAO);

        return u.login(user.getEmail(), user.getSenha());
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}")
    void editar(@RequestBody Usuario user, @PathVariable UUID id) {
        Usuario usuario = user;

        UsuarioDAO uDAO = new UsuarioDAO();
        UsuarioService uSVC = new UsuarioService(uDAO);

        usuario.setId(id);
        uSVC.editar(usuario);
    }
    
    @GetMapping("/{id}")
    public Usuario pesquisar(@PathVariable UUID id){
        UsuarioDAO uDAO = new UsuarioDAO();
        UsuarioService uSVC = new UsuarioService(uDAO);
        
        return uSVC.pesquisar(id);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deletar(@PathVariable UUID id) {
        UsuarioDAO uDAO = new UsuarioDAO();
        UsuarioService uSVC = new UsuarioService(uDAO);
        
        uSVC.deletar(id);
    }
}
