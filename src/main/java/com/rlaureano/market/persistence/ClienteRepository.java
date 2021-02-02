package com.rlaureano.market.persistence;

import com.rlaureano.market.domain.Client;
import com.rlaureano.market.domain.repository.ClientRepository;
import com.rlaureano.market.persistence.crud.ClienteCrudRepository;
import com.rlaureano.market.persistence.entity.Cliente;
import com.rlaureano.market.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;
    @Autowired
    private ClientMapper clientMapper;

    public List<Client> getAll(){
        List<Cliente> clientes= (List<Cliente>) clienteCrudRepository.findAll();
        return clientMapper.toClients(clientes);
    }

    @Override
    public Optional<Client> getByClientId(String clientId) {

        return clienteCrudRepository.findById(clientId).map(cliente -> clientMapper.toClient(cliente));
    }

    @Override
    public Client save(Client client) {
        Cliente cliente = clientMapper.toCliente(client);
        return clientMapper.toClient(clienteCrudRepository.save(cliente));
    }

    public void delete(String idCliente){
        clienteCrudRepository.deleteById(idCliente);
    }
}
