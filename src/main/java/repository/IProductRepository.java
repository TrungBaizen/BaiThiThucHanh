package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    boolean add(Product product);
    boolean delete(int id);
    boolean update(int id, Product product);
    List<Product> findAll();
    Product findProductById(int id);

}
