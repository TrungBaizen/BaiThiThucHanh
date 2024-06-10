package repository;

import config.ConnectionDB;
import model.Category;
import model.Product;
import querysql.CategorySQL;
import querysql.ProductSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository{
    private Connection connection;
    private ICategoryRepository categoryRepository;
    public CategoryRepository(){
        connection = ConnectionDB.connection();
        categoryRepository = new CategoryRepository();
    }
    @Override
    public boolean add(Category category) {
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionDB.connection();
            preparedStatement = connection.prepareCall(CategorySQL.ADD_CATEGORY);
            preparedStatement.setString(1, category.getNameCategory());
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
            preparedStatement = connection.prepareCall(CategorySQL.DELETE_CATEGORY);
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
    public boolean update(int id, Category category) {
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionDB.connection();
            preparedStatement = connection.prepareCall(CategorySQL.UPDATE_CATEGORY);
            preparedStatement.setString(1, category.getNameCategory());
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
    public List<Category> findAll() {
        PreparedStatement preparedStatement = null;
        List<Category> listCategory = null;
        try {
            connection = ConnectionDB.connection();
            preparedStatement = connection.prepareStatement(CategorySQL.FIND_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            listCategory = new ArrayList<>();

            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setNameCategory("nameCategory");
                listCategory.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCategory;
    }

    @Override
    public Category findCategoryById(int id) {
        PreparedStatement preparedStatement = null;
        Category category = null;
        try {
            connection = ConnectionDB.connection();
            preparedStatement = connection.prepareCall(CategorySQL.FIND_CATEGORY_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            category = new Category();
            if (rs.next()) {
                category.setId(rs.getInt("id"));
                category.setNameCategory(rs.getString("nameCategory"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }
}
