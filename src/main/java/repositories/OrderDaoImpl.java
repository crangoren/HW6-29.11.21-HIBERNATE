package repositories;

import data.Client;
import data.Order;
import data.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import utils.SessionFactoryUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderDaoImpl implements OrderDao{
    private SessionFactoryUtils sessionFactoryUtils;


    public OrderDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public List<Product> getPurchaseListByClientId(Long id) {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> purchases = session.createQuery("select order.product from Order order where order.client.id = :id", Product.class)
                    .setParameter("id", id)
                    .getResultList();
            session.getTransaction().commit();
            return Collections.unmodifiableList(purchases);
        }
    }

    @Override
    public List<Client> getCustomersByProdId(Long id) {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Client> customers = session.createQuery("select order.client from Order order where order.product.id = :id", Client.class)
                    .setParameter("id", id)
                    .getResultList();
            session.getTransaction().commit();
            return Collections.unmodifiableList(customers);
        }
    }

    @Override
    public Order purchase(Order order) {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            order.setClientId(order.getClientId());
            order.setProductId(order.getProductId());
            session.save(order);
            session.getTransaction().commit();
        } return order;
    }

    @Override
    public List<Order> findAllOrders() {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Order> orders = session.createQuery("select o from Order o").getResultList();
            session.getTransaction().commit();
            return Collections.unmodifiableList(orders);
        }
    }

}
