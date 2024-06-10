package controller;

import service.IProductService;
import service.ProductService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "home":
                try {
                    productService.showHome(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "create":
                try {
                    productService.showFromCreate(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                productService.deleteProduct(request, response);
                break;
            case "update":
                productService.deleteProduct(request, response);
                break;
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                productService.addProduct(req, resp);
                break;
            case "update":
                productService.updateProduct(req, resp);
                break;
        }
    }
}
