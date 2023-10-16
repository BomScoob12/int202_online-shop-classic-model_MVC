package sit.int202.onlineshopwebapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.onlineshopwebapp.entities.Office;

public class TestJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        System.out.println(emf);
        EntityManager em = emf.createEntityManager();
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
}
