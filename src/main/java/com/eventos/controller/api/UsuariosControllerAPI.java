package com.eventos.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eventos.model.Tipos;
import com.eventos.model.Usuarios;
import com.eventos.repository.UsuariosRepository;
import com.eventos.service.ITiposService;
import com.eventos.service.IUsuariosService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosControllerAPI {

    @Autowired
    private IUsuariosService usuariosService;

    @Autowired
    private ITiposService tiposService;

    @GetMapping("")
    public List<Usuarios> listarUsuarios() {
        return usuariosService.listaUser();
    }

    @GetMapping("/{id}")
    public Usuarios getUsuario(@PathVariable Integer id) {
        return usuariosService.buscarUserPorId(id);
    }

    @PostMapping("")
    public Usuarios createUsuario(@RequestBody Usuarios usuario) {
        usuariosService.guardarUser(usuario);
        return usuario;
    }

    @PutMapping("/{id}")
    public Usuarios updateUsuario(@PathVariable Integer id, @RequestBody Usuarios usuario) {
        usuario.setIdUsuario(id);
        usuariosService.guardarUser(usuario);
        return usuario;
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Integer id) {
        usuariosService.eliminarUser(id);
    }
}
