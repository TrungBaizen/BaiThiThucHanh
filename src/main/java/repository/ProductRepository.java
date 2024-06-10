package repository;

import config.ConnectionDB;
import model.Category;
import model.Product;
import querysql.CategorySQL;
import querysql.ProductSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private ICategoryRepository categoryRepository;
    private Connection connection;

    public ProductRepository() {
        connection = ConnectionDB.connection();
        categoryRepository = new CategoryRepository();
    }

    @Override
    public boolean add(Product product) {
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionDB.connection();
            preparedStatement = connection.prepareCall(ProductSQL.ADD_PRODUCT);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescriptions());
            preparedStatement.setInt(6, product.getCategory().getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionDB.connection();
            preparedStatement = connection.prepareCall(ProductSQL.DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Product product) {
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionDB.connection();
            preparedStatement = connection.prepareCall(ProductSQL.UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescriptions());
            preparedStatement.setInt(6, product.getCategory().getId());
            preparedStatement.setInt(7,id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> findAll() {
        PreparedStatement preparedStatement = null;
        List<Product> listProduct = null;
        try {
            connection = ConnectionDB.connection();
            preparedStatement = connection.prepareStatement(ProductSQL.FIND_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            listProduct = new ArrayList<>();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setNameProduct(rs.getString("productName"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("productStatus"));
                product.setDescriptions(rs.getString("descriptions"));
                int id = rs.getInt("category_id");
                Category category = categoryRepository.findCategoryById(id);
                product.setCategory(category);
                listProduct.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProduct;
    }

    @Override
    public Product findProductById(int id) {
        PreparedStatement preparedStatement = null;
        Product product = null;
        try {
            connection = ConnectionDB.connection();
            preparedStatement = connection.prepareCall(ProductSQL.FIND_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            product = new Product();
            if (rs.next()) {
                product.setId(rs.getInt("id"));
                product.setNameProduct(rs.getString("nameProduct"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setColor(rs.getString("color"));
                product.setDescriptions(rs.getString("descriptions"));
                int idCategory = rs.getInt("category_id");
                Category category = categoryRepository.findCategoryById(idCategory);
                product.setCategory(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

}

