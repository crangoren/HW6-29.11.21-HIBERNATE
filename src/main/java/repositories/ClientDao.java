package repositories;

import data.Client;

import java.util.List;

public interface ClientDao {
    Client getClientById(Long id);
    List<Client> findAllClients();

}
