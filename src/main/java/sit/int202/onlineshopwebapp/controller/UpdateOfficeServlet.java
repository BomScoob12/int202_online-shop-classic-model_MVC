package sit.int202.onlineshopwebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.onlineshopwebapp.entities.Office;
import sit.int202.onlineshopwebapp.repositories.OfficeRepository;
import sit.int202.onlineshopwebapp.utils.CheckParam;

import java.io.IOException;

@WebServlet(name = "UpdateOfficeServlet", value = "/update-office")
public class UpdateOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String officeCode = req.getParameter("editOffice");
        OfficeRepository officeRepository = new OfficeRepository();
        Office findedOffice = officeRepository.findOfficeByCode(officeCode);
        if (findedOffice == null) {
            req.setAttribute("errorUpdatingOffice", "Office does not exists.");
        } else {
            req.setAttribute("officeData", findedOffice);
        }
        req.getRequestDispatcher("update-office.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] params = { //require value
                req.getParameter("currentOfficeCode"),
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
            Office targetOffice = officeRepository.findOfficeByCode(params[0]);
            if (targetOffice == null) {
                req.setAttribute("errorUpdatingOffice", "Office does not exists.");
            } else {
                //additional null value
                String addr2 = req.getParameter("newOfficeAddr2").isEmpty()
                        || req.getParameter("newOfficeAddr2") == null ?
                        null : req.getParameter("newOfficeAddr2");
                targetOffice.setOfficeCode(params[0]);
                targetOffice.setCity(params[1]);
                targetOffice.setPhoneNumber(params[2]);
                targetOffice.setAddressLine1(params[3]);
                targetOffice.setAddressLine2(addr2);
                targetOffice.setState(params[4]);
                targetOffice.setCountry(params[5]);
                targetOffice.setPostalCode(params[6]);
                targetOffice.setTerritory(params[7]);
            }

            if (officeRepository.update(targetOffice)) {
                System.out.println("success");
                officeRepository.close();
            } else {
                System.out.println("error officeCode");
                req.setAttribute("errorAddingOffice", "Office code already exists.");
                req.getRequestDispatcher("/update-office.jsp").forward(req, resp);
            }
        } else {
            System.out.println("error updating. It has null value");
            req.setAttribute("errorUpdatingOffice", "error adding. It has null value");
            OfficeRepository officeRepository = new OfficeRepository();
            Office findedOffice = officeRepository.findOfficeByCode(req.getParameter("currentOfficeCode"));
            req.setAttribute("officeData", findedOffice);
            req.getRequestDispatcher("/update-office.jsp").forward(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/office-list");
    }
}
