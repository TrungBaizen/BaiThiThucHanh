package service;

import model.Category;
import model.Product;
import repository.ICategoryRepository;
import repository.IProductRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductService implements IProductService {
    private ICategoryRepository categoryRepository;
    private IProductRepository productRepository;

    public ProductService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nameProduct = request.getParameter("nameProduct");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        Category category = categoryRepository.findCategoryById(category_id);
        Product product = new Product(nameProduct, price, quantity, color, description, category);
        productRepository.add(product);
        response.sendRedirect("/products?action=home");
    }

    @Override
    public void showHome(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Product> productList = productRepository.findAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/home.jsp");
        request.setAttribute("productList", productList);
        requestDispatcher.forward(request, response);
    }

    @Override
    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productRepository.delete(id);
        response.sendRedirect("/product?action=home");
    }

    @Override
    public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nameProduct = request.getParameter("nameProduct");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String descriptions = request.getParameter("description");
        int category_id = Integer.parseInt(request.getParameter("category_Id"));
        Category category = categoryRepository.findCategoryById(category_id);
        Product product = new Product(nameProduct, price,quantity,color ,descriptions, category);
        productRepository.update(id, product);
        response.sendRedirect("/product?action=home");
    }

    @Override
    public void showFromCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/create.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void showFromUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productRepository.findAll().get(id);
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/edit.jsp");
        requestDispatcher.forward(request, response);
    }
}
