package sit.int202.onlineshopwebapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.onlineshopwebapp.entities.Employee;
import sit.int202.onlineshopwebapp.utils.Environment;
import sit.int202.onlineshopwebapp.entities.Office;

import java.util.List;
import java.util.Scanner;

public class TestQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.UNIT_NAME);
        EntityManager em = emf.createEntityManager();
//        Query query = em.createNamedQuery("OFFICE.FIND_ALL");
        Query query = em.createNamedQuery("OFFICE.FIND_BY_COUNTRY");
        System.out.print("Find office by country start with: ");
        String country = new Scanner(System.in).next();
        query.setParameter("country", country+"%");

        List<Office>  offices = query.getResultList();
        for(Office office : offices) {
            System.out.printf("(%2s) %-25s %-15s %-12s\n",
                    office.getOfficeCode(), office.getAddressLine1(),
                    office.getCity(), office.getCountry());
        }
        System.out.println("-------------------------");
        List<Employee> employees = em.createNamedQuery("EMPLOYEE.FINDALL").getResultList();
        for(Employee employee : employees) {
            System.out.printf("%4d %-10s %-12s %-20s\n",
                    employee.getId(), employee.getFirstname(),
                    employee.getLastname(), employee.getJobTitle());
        }
        em.close();
    }
}
