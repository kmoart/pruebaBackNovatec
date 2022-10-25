package com.novatec.pruebaNovatec.repositories;

import com.novatec.pruebaNovatec.models.usuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<usuarioModel,Long> {
}
