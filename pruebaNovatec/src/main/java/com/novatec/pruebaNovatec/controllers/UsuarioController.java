package com.novatec.pruebaNovatec.controllers;

import com.novatec.pruebaNovatec.models.usuarioModel;
import com.novatec.pruebaNovatec.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<usuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public usuarioModel guardarUsuario(@RequestBody usuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

}
