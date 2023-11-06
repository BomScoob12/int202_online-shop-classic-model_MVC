package sit.int202.onlineshopwebapp.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.onlineshopwebapp.entities.Product;

import java.util.List;

public class ProductRepository {
    private static int PAGE_SIZE = 10;
    private EntityManager entityManager;
    public int getDefaultPageSize(){
        return PAGE_SIZE;
    }

    private EntityManager getEntityManager(){
        if (entityManager == null || !entityManager.isOpen()){
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Product> findAll(int page, int pageSize){
        int startPos = (page - 1) * pageSize;
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("PRODUCT.FIND_ALL");
        query.setFirstResult(startPos);
        query.setMaxResults(getDefaultPageSize());
        List<Product> productList = query.getResultList();
        entityManager.close();
        return productList;
    }

    public int countAll(){
        EntityManager entityManager = getEntityManager();
//        parse to Number and get int value
        return ((Number) entityManager.createNamedQuery("PRODUCT.COUNT").getSingleResult()).intValue();
    }

    public void close(){
        EntityManager entityManager = getEntityManager();
        if(entityManager != null || entityManager.isOpen()){
            entityManager.close();
        }
    }
}
