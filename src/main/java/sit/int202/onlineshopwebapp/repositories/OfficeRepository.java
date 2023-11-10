package sit.int202.onlineshopwebapp.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.onlineshopwebapp.entities.Office;

import java.util.List;

public class OfficeRepository {
    private EntityManager entityManager;

    private EntityManager getEntityManager(){
        if (entityManager == null || !entityManager.isOpen()){
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Office> findAll(){
        return getEntityManager().createNamedQuery("OFFICE.FINDALL").getResultList();
    }
    public List<String> getAllCountry() {
        return getEntityManager().createNamedQuery("OFFICE.GET_ALL_COUNTRY").getResultList();
    }
    public List<String> getAllCity(){
        return getEntityManager().createNamedQuery("OFFICE.GET_ALL_CITY").getResultList();
    }

    public Office findOfficeByCode(String officeCode){
        return getEntityManager().find(Office.class, officeCode);
    }

    public void close(){
        if(entityManager != null || entityManager.isOpen()){
            entityManager.close();
        }
    }

    public boolean insert(Office office){
        try{
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(office);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            e.getStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(Office office){
        if(office == null){
            EntityManager entityManager = getEntityManager();
            if(entityManager.contains(office)) {
                entityManager.getTransaction().begin();
                entityManager.remove(office);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return delete(office.getOfficeCode());
            }
        }
        return false;
    }

    public boolean delete(String officeCode){
        EntityManager entityManager = getEntityManager();
        Office office = findOfficeByCode(officeCode);
        if(office != null){
            entityManager.getTransaction().begin();
            entityManager.remove(office);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean update(Office newOffice){
        if(newOffice != null){
            EntityManager entityManager = getEntityManager();
            Office office = findOfficeByCode(newOffice.getOfficeCode());
            if(office != null){
                entityManager.getTransaction().begin();
                entityManager.setProperty("officeCode", office.getOfficeCode());
                entityManager.getTransaction().commit();
                return true;
            }
        }
        return false;
    }

    public List<Office> findByCityOrCountry(String cityOrCountry) {
        cityOrCountry = cityOrCountry.toLowerCase()+'%';
        Query query = getEntityManager().createNamedQuery("OFFICE.FIND_BY_CITY_OR_COUNTRY");
        query.setParameter("city", cityOrCountry);
        query.setParameter("country", cityOrCountry);
        return query.getResultList();
    }
}
