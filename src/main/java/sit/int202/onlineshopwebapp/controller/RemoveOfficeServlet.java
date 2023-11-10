package sit.int202.onlineshopwebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.onlineshopwebapp.repositories.OfficeRepository;
import sit.int202.onlineshopwebapp.utils.CheckParam;

import java.io.IOException;

public class RemoveOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/remove-office.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String removeParam = req.getParameter("removeId");
        if(removeParam == null || removeParam.isEmpty()){
            req.setAttribute("errorRemove", "Invalid id");
        } else {
            if(removeParam.equals("0")) req.setAttribute("errorRemove", "Invalid id");
            doRemove(removeParam, req, resp);
        }
        req.getRequestDispatcher("/office-list").forward(req, resp);

    }

    private void doRemove(String removeId, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        OfficeRepository officeRepository = new OfficeRepository();
        if(officeRepository.delete(removeId)){
            System.out.println("Success");
            req.setAttribute("removeStatus", "remove success");
            officeRepository.close();
        } else {
            System.out.println("unsuccessful");
            req.setAttribute("removeStatus", "remove unsuccessful");
            officeRepository.close();
        }
    }
}
