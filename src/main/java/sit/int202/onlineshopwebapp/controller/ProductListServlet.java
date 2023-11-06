package sit.int202.onlineshopwebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.onlineshopwebapp.entities.Product;
import sit.int202.onlineshopwebapp.repositories.ProductRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/product-list")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductRepository productRepository = new ProductRepository();
        String pageParam = req.getParameter("page");
        String pageSizeParam = req.getParameter("pageSize");
        int page = pageParam == null ? 1 : Integer.parseInt(pageParam);
        int pageSize = pageSizeParam == null ? productRepository.getDefaultPageSize() : Integer.parseInt(pageSizeParam);

        List<Product> productList = productRepository.findAll(page, pageSize);
        req.setAttribute("products", productList);
        req.setAttribute("page", page);
        req.setAttribute("pageSize", pageSize);
        req.setAttribute("itemCount", productRepository.countAll());
        getServletContext().getRequestDispatcher("/product-list.jsp").forward(req, resp);
    }
}
