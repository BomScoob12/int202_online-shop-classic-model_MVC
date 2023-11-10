package sit.int202.onlineshopwebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.onlineshopwebapp.HelloServlet;
import sit.int202.onlineshopwebapp.entities.Office;
import sit.int202.onlineshopwebapp.repositories.OfficeRepository;
import sit.int202.onlineshopwebapp.utils.CheckParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@WebServlet(name = "AddingOfficeServlet", value = "/adding-office")
public class AddingOfficeServlet extends HelloServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String [] param = {
                req.getParameter("newOfficeCode"), //0
                req.getParameter("newOfficeCity"), //1
                req.getParameter("newOfficePhone"), //2
                req.getParameter("newOfficeAddr1"), //3
                req.getParameter("newOfficeState"), //4
                req.getParameter("newOfficeCountry"), //5
                req.getParameter("newOfficePostalCode"), //6
                req.getParameter("newOfficeTerritory") //7
        };
        Office newOffice = new Office();
        newOffice.setOfficeCode(param[0]);
        newOffice.setCity(param[1]);
        newOffice.setPhoneNumber(param[2]);
        newOffice.setAddressLine1(param[3]);
        newOffice.setAddressLine2(req.getParameter("newOfficeAddr2"));
        newOffice.setState(param[4]);
        newOffice.setCountry(param[5]);
        newOffice.setPostalCode(param[6]);
        newOffice.setTerritory(param[7]);
        if(checkNullValue(param)){
            System.out.println("Valid");
            OfficeRepository officeRepository = new OfficeRepository();
            if (officeRepository.insert(newOffice)) {
                System.out.println("success");
                officeRepository.close();
            } else {
                System.out.println("error officecode");
                req.setAttribute("errorAddingOffice", "Office code already exists.");
            }
        } else {
            System.out.println("error adding");
            req.setAttribute("errorAddingOffice", "missing data.");
        }
        req.getRequestDispatcher("/office-list").forward(req, resp);
    }

    private boolean checkNullValue(String [] param){
        if(CheckParam.isValidString(param)){
            return true;
        }
        return false;
    }
}
