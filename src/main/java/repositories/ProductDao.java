package repositories;

import data.Product;

import java.util.List;

public interface ProductDao {
    Product getProductById(Long id);
    List<Product> findAllProducts();
    void changePrice(Long productId, Integer price);
}
