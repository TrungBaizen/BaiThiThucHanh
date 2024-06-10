package service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IProductService {
    void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void showHome(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
    void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException;
    void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException;
    void showFromCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    void showFromUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
