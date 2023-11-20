package sit.int202.onlineshopwebapp.controller.oldController;

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
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        req.setAttribute("allCountry", officeRepository.getAllCountry());
        req.setAttribute("allCity", officeRepository.getAllCity());
        doFilter(req, resp, officeRepository);
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

