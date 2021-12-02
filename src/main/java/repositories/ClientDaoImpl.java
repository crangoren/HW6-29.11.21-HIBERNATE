package repositories;

import data.Client;
import data.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import utils.SessionFactoryUtils;

import java.util.Collections;
import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {
    private SessionFactoryUtils sessionFactoryUtils;


    public ClientDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public Client getClientById(Long id) {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.getTransaction().commit();
            return client;
        }
    }

    public List<Client> findAllClients() {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Client> clients = session.createQuery("select c from Client c").getResultList();
            session.getTransaction().commit();
            return Collections.unmodifiableList(clients);
        }
    }

}

