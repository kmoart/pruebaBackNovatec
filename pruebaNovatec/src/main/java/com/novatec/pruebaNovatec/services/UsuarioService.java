package com.novatec.pruebaNovatec.services;

import com.novatec.pruebaNovatec.models.usuarioModel;
import com.novatec.pruebaNovatec.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<usuarioModel> obtenerUsuarios(){
        return (ArrayList<usuarioModel>) usuarioRepository.findAll();
    }

    public usuarioModel guardarUsuario(usuarioModel usuario){
        return usuarioRepository.save(usuario);
    }


}
