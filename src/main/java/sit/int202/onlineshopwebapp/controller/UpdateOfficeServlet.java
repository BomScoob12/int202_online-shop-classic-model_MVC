package sit.int202.onlineshopwebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.onlineshopwebapp.entities.Office;
import sit.int202.onlineshopwebapp.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "UpdateOfficeServlet", value = "/update-office")
public class UpdateOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String officeCode = req.getParameter("editOffice");
        OfficeRepository officeRepository = new OfficeRepository();
        Office findedOffice = officeRepository.findOfficeByCode(officeCode);
        if (findedOffice == null) {
            req.setAttribute("errorUpdate", "Office does not exists.");
        } else {
            req.setAttribute("officeData", findedOffice);
        }
        req.getRequestDispatcher("update-office.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
