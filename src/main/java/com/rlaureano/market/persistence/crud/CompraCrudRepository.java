package com.rlaureano.market.persistence.crud;

import com.rlaureano.market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra,Integer> {

    Optional<List<Compra>> findByidCliente(String idCliente);

}
