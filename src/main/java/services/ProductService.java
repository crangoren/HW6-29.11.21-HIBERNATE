package services;

import data.Client;
import data.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ProductDao;
import repositories.ProductDaoImpl;
import utils.SessionFactoryUtils;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    private ProductDaoImpl productDaoImpl;

    @Autowired
    public ProductService(ProductDaoImpl productDaoImpl) {
        this.productDaoImpl = productDaoImpl;
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productDaoImpl.findAllProducts());
    }

    public Product getProductById(Long id) {
        return productDaoImpl.getProductById(id);
    }

    public List<Product> findAllProducts() {
        return Collections.unmodifiableList(productDaoImpl.findAllProducts());
    }
}
