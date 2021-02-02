package com.rlaureano.market.persistence.crud;

import com.rlaureano.market.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {

}
