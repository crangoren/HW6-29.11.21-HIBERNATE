package repositories;

import data.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import utils.SessionFactoryUtils;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    private SessionFactoryUtils sessionFactoryUtils;


    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public Product getProductById(Long id) {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public List<Product> findAllProducts() {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return Collections.unmodifiableList(products);
        }
    }

    @Override
    public void changePrice(Long productId, Integer price) {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.createQuery("update Product set price = :price where id = :id")
                    .setParameter("id", productId)
                    .setParameter("price", price)
                    .executeUpdate();
            session.getTransaction().commit();
        }

    }

    @Override
    public String toString() {
        return "ProductDaoImpl{" +
                "sessionFactoryUtils=" + sessionFactoryUtils +
                '}';
    }
}
