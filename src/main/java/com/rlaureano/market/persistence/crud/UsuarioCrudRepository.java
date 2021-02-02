package com.rlaureano.market.persistence.crud;

import com.rlaureano.market.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioCrudRepository extends CrudRepository<Usuario,Integer> {

    Usuario findByNombre(String name);
}
