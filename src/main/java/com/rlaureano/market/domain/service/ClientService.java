package com.rlaureano.market.domain.service;

import com.rlaureano.market.domain.Client;
import com.rlaureano.market.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getByClientId(String clientId){
        return clientRepository.getByClientId(clientId);
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public boolean delete(String clientId){
        return clientRepository.getByClientId(clientId).map(client -> {
            clientRepository.delete(clientId);
            return true;
        }).orElse(false);
    }
}
