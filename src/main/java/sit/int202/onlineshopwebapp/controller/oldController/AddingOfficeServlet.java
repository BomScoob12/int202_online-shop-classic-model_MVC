package sit.int202.onlineshopwebapp.controller.oldController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.onlineshopwebapp.entities.Office;
import sit.int202.onlineshopwebapp.repositories.OfficeRepository;
import sit.int202.onlineshopwebapp.utils.CheckParam;

import java.io.IOException;

@WebServlet(name = "AddingOfficeServlet", value = "/adding-office")
public class AddingOfficeServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add-office.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] params = { //require value
                req.getParameter("newOfficeCode"), //0
                req.getParameter("newOfficeCity"), //1
                req.getParameter("newOfficePhone"), //2
                req.getParameter("newOfficeAddr1"), //3
                req.getParameter("newOfficeState"), //4
                req.getParameter("newOfficeCountry"), //5
                req.getParameter("newOfficePostalCode"), //6
                req.getParameter("newOfficeTerritory") //7
        };
        if (CheckParam.isValidString(params)) {
            System.out.println("Valid");
            OfficeRepository officeRepository = new OfficeRepository();
            Office newOffice = new Office();
            //additional null value
            String addr2 = req.getParameter("newOfficeAddr2").isEmpty()
                    || req.getParameter("newOfficeAddr2") == null ?
                    null : req.getParameter("newOfficeAddr2");

            newOffice.setOfficeCode(params[0]);
            newOffice.setCity(params[1]);
            newOffice.setPhoneNumber(params[2]);
            newOffice.setAddressLine1(params[3]);
            newOffice.setAddressLine2(addr2);
            newOffice.setState(params[4]);
            newOffice.setCountry(params[5]);
            newOffice.setPostalCode(params[6]);
            newOffice.setTerritory(params[7]);

            if (officeRepository.insert(newOffice)) {
                System.out.println("success");
                officeRepository.close();
            } else {
                System.out.println("error officeCode");
                req.setAttribute("errorAddingOffice", "Office code already exists.");
                req.getRequestDispatcher("/add-office.jsp").forward(req, resp);
            }
        } else {
            System.out.println("error adding. It has null value");
            req.setAttribute("errorAddingOffice", "error adding. It has null value");
            req.getRequestDispatcher("/add-office.jsp").forward(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/office-list");
    }
}
