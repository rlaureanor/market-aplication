package com.rlaureano.market.domain.repository;

import com.rlaureano.market.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    List<Client> getAll();
    Optional<Client> getByClientId(String clientId);
    Client save(Client client);
    void delete(String clientId);


}
