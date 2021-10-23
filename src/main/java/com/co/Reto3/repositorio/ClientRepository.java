package com.co.Reto3.repositorio;

import com.co.Reto3.modelo.Client;
import com.co.Reto3.repositorio.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientRepository;

    public List<Client> getAllClients(){
        return (List<Client>) clientRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.findById(id);
    }

    public Client saveClient(Client cliente){
        return clientRepository.save(cliente);
    }

    public void delete(Client client){clientRepository.delete(client);}
}
