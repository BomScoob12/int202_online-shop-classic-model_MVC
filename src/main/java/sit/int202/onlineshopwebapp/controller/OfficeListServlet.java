package sit.int202.onlineshopwebapp.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OfficeListServlet", value = "/office-list")
public class OfficeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository repository = new OfficeRepository();
        request.setAttribute("offices", repository.findAll());
        String officeCode = request.getParameter("officeCode");
        if (officeCode != null) {
            request.setAttribute("selectedOffice", repository.find(officeCode));
        }
        getServletContext().getRequestDispatcher("/office-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
