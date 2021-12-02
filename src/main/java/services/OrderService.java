package services;

import data.Client;
import data.Order;
import data.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.OrderDaoImpl;
import utils.SessionFactoryUtils;

import java.util.Collections;
import java.util.List;

@Service
public class OrderService {
    private OrderDaoImpl orderDaoImpl;

    @Autowired
    public OrderService(OrderDaoImpl orderDaoImpl) {
        this.orderDaoImpl = orderDaoImpl;
    }

    public List<Client> getCostumersByProdId(Long id){
        return Collections.unmodifiableList(orderDaoImpl.getCustomersByProdId(id));
    }
    
    public List<Product> getPurchaseListByClientId(Long id){
        return Collections.unmodifiableList(orderDaoImpl.getPurchaseListByClientId(id));
    }


    public Order purchase(Order order) {
        return orderDaoImpl.purchase(order);
    }

    public List<Order> findAllOrders() {
        return Collections.unmodifiableList(orderDaoImpl.findAllOrders());
    }
}
