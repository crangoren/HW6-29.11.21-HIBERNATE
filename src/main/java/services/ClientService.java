package services;

import data.Client;
import data.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ClientDao;
import repositories.ClientDaoImpl;

import java.util.Collections;
import java.util.List;


@Service
public class ClientService {
    private ClientDaoImpl clientDaoImpl;

    @Autowired
    public ClientService(ClientDaoImpl clientDaoimpl) {
        this.clientDaoImpl = clientDaoimpl;
    }

    public List<Client> getClientList(){
        return Collections.unmodifiableList(clientDaoImpl.findAllClients());
    }

    public Client getClientById(Long id) {
        return clientDaoImpl.getClientById(id);
    }
}
