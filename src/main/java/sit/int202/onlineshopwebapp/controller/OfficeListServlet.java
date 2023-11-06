package sit.int202.onlineshopwebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.onlineshopwebapp.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeListServlet", value = "/office-list")
public class OfficeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        req.setAttribute("offices", officeRepository.findAll());
        String officeCode = req.getParameter("officeCode");
        if (officeCode != null) {
            req.setAttribute("selectedOffice", officeRepository.findOfficeByCode(officeCode));
        }
        this.getServletContext().getRequestDispatcher("/office-list.jsp").forward(req, resp);
    }
}

