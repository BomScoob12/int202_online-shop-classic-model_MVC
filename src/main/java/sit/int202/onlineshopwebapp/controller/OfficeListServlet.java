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
        doFilter(req, resp, officeRepository);
        String officeCode = req.getParameter("selectOfficeCode");
        if (officeCode != null) {
            req.setAttribute("selectedOffice", officeRepository.findOfficeByCode(officeCode));
        }
        req.setAttribute("allCountry", officeRepository.getAllCountry());
        req.setAttribute("allCity", officeRepository.getAllCity());
        this.getServletContext().getRequestDispatcher("/office-list.jsp").include(req, resp);
    }

    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, OfficeRepository officeRepository){
        String filterValue = req.getParameter("filterValue") == null ? "all" : req.getParameter("filterValue");
        if(filterValue.equalsIgnoreCase("all")){
            req.setAttribute("offices", officeRepository.findAll());
        } else {
            req.setAttribute("offices", officeRepository.findByCityOrCountry(filterValue));
        }
        req.setAttribute("selectedFilterValue", filterValue);
    }
}

