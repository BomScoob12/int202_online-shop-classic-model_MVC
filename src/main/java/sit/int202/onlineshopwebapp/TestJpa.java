package sit.int202.onlineshopwebapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.onlineshopwebapp.entities.Employee;
import sit.int202.onlineshopwebapp.entities.Office;

import java.util.List;
import java.util.Scanner;

public class TestJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        System.out.println(emf);
        EntityManager em = emf.createEntityManager();
//        Office office = em.find(Office.class, "8");

//        testEMFOffice(em);
//        testEmployee(em);
//        testNamedQuery(em);
        testNamedQueryEmp(em);
    }

    private static void testEMFOffice(EntityManager em){

        Office office = em.find(Office.class, "8");

        //handle null
        if(office != null) System.out.println(office);
        else System.out.println("Specify office code does not exist!");

        Office newOffice = new Office();
        newOffice.setOfficeCode("8");
        newOffice.setAddressLine1(office.getAddressLine1());
        newOffice.setAddressLine2(office.getAddressLine2());
        newOffice.setCity("Bangmod");
        newOffice.setCountry("Thailand");
        newOffice.setState("Bangkok");
        newOffice.setPhoneNumber(office.getPhoneNumber());
        newOffice.setPostalCode("10140");
        newOffice.setTerritory(office.getTerritory());
        em.getTransaction().begin();
        em.persist(newOffice);
        em.getTransaction().commit();
////        em.flush();
        em.close();
    }
    private static void testEmployee(EntityManager em){
        Employee emp1 = em.find(Employee.class, "1056");

        if (emp1 != null) System.out.println(emp1);
        else {
            System.out.println("This id does not exist");
            Employee newEmp = new Employee();
            newEmp.setId(1001);
            newEmp.setLastname("Johnson");
            newEmp.setFirstname("Adum");
            newEmp.setEmail("adum@gmail.com");
            newEmp.setExtension("x4611");
            newEmp.setJobTitle("StudentManager");
            newEmp.setReportsTo(1056);
            newEmp.setOfficeCode("7");

            em.getTransaction().begin();
            em.persist(newEmp);
            em.getTransaction().commit();
            em.close();
        }
    }
    private static void testNamedQuery(EntityManager em){
        Query query = em.createNamedQuery("OFFICE.FIND_BY_COUNTRY");
        query.setParameter("country", "U%");
        //set parameter for country

        List<Office> officeList = query.getResultList();
        for (Office office : officeList){
            System.out.printf("%-4s, %-10s %-15s %-20s\n",
                    office.getOfficeCode(),
                    office.getCountry(),
                    office.getPhoneNumber(),
                    office.getPostalCode());
        }
    }
    private static void testNamedQueryEmp(EntityManager em){
        Query query = em.createNamedQuery("EMPLOYEE.FINDALL");
        int start = 1;
        int pageSize = 5;
        query.setMaxResults(pageSize);
        while(true) {
            query.setFirstResult(start);
            List<Employee> employees = query.getResultList();
            if (employees.isEmpty()){
                break;
            }
            Scanner sc = new Scanner(System.in);
            String receive = sc.nextLine();
            if (receive.equals("2")) {
                displayEmployee(employees);
                start += pageSize;
                displayEmployee(employees);
                start += pageSize;

            } else {
                displayEmployee(employees);
                start += pageSize;
            }
            System.out.println("Please 'ENTER' to view next page or type 2 to view next 2 page.");

        }
    }

    private static void displayEmployee(List<Employee> listEmp){
        for(Employee emp : listEmp){
            System.out.printf("%-4s, %-10s %-12s %-20s\n",
                    emp.getId(),
                    emp.getFirstname(),
                    emp.getLastname(),
                    emp.getJobTitle());
        }
    }

}
