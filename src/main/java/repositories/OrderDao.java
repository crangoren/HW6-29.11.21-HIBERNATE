package repositories;

import data.Client;
import data.Order;
import data.Product;

import java.util.List;

public interface OrderDao {
    List<Product> getPurchaseListByClientId(Long id);
    List<Client> getCustomersByProdId(Long id);
    Order purchase(Order order);
    List<Order> findAllOrders();

}
