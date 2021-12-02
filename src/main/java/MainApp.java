import data.Order;
import data.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.*;
import utils.SessionFactoryUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("Context");
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();

//        Scanner in = new Scanner(System.in);
//        Long request = in.nextLong();


        try {
            ProductDao productDao =new ProductDaoImpl(sessionFactoryUtils);
            ClientDao clientDao = new ClientDaoImpl(sessionFactoryUtils);
            OrderDao orderDao = new OrderDaoImpl(sessionFactoryUtils);

            System.out.println(productDao.findAllProducts());
            orderDao.purchase(new Order(3L, 4L));
            System.out.println(orderDao.findAllOrders());
            System.out.println(orderDao.getCustomersByProdId(4L));
            System.out.println(orderDao.getPurchaseListByClientId(3L));



        } catch (Exception e) {
        e.printStackTrace();
        } finally {
        sessionFactoryUtils.shutdown();
        }
    }

}
