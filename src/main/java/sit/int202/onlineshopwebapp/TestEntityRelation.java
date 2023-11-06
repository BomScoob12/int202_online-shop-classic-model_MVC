package sit.int202.onlineshopwebapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.onlineshopwebapp.entities.Employee;
import sit.int202.onlineshopwebapp.entities.Environment;
import sit.int202.onlineshopwebapp.entities.Office;

import java.util.List;

public class TestEntityRelation {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.UNIT_NAME);
        System.out.println(emf);
        EntityManager em = emf.createEntityManager();

        List<Office> officeList = em.createNamedQuery("OFFICE.FINDALL").getResultList();
        for (Office office : officeList){
            System.out.printf("%-4s, %-10s %-15s %-20s\n",
                    office.getOfficeCode(),
                    office.getCountry(),
                    office.getState(),
                    office.getPostalCode());
            System.out.println("-------------------------");
            for(Employee emp : office.getEmployeeList()){
                System.out.printf("%s, %-10s %-12s %-20s\n",
                        emp.getId(),
                        emp.getFirstname(),
                        emp.getLastname(),
                        emp.getJobTitle());
            }
            System.out.println();
        }
    }
}
