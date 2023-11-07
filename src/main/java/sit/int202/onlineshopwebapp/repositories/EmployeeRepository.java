package sit.int202.onlineshopwebapp.repositories;

import jakarta.persistence.EntityManager;
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
        getEntityManager().createNamedQuery("EMPLOYEE.FIND_BY_OFFICECODE").getResultList();
        return null
    }
}
