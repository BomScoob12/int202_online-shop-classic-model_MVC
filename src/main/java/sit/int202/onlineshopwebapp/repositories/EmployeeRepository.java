package sit.int202.onlineshopwebapp.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.onlineshopwebapp.entities.Employee;
import sit.int202.onlineshopwebapp.entities.Environment;

import java.util.List;

public class EmployeeRepository {
    private EntityManager entityManager;

    private EntityManager getEntityManager(){
        if (entityManager == null || !entityManager.isOpen()){
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Employee> findAll(){
        return getEntityManager().createNamedQuery("EMPLOYEE.FIND_ALL").getResultList();
    }

    public List<Employee> findByOfficeCode(String officeCode){
        Query query = getEntityManager().createNamedQuery("EMPLOYEE.FIND_BY_OFFICE_CODE");
        query.setParameter("officeCode", officeCode);
        return query.getResultList();
    }
}
