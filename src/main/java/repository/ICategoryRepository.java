package repository;

import model.Category;
import model.Product;

import java.util.List;

public interface ICategoryRepository {
    boolean add(Category category);
    boolean delete(int id);
    boolean update(int id, Category category);
    List<Category> findAll();
    Category findCategoryById(int id);
}
