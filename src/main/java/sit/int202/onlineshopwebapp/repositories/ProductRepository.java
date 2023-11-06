package sit.int202.onlineshopwebapp.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.onlineshopwebapp.entities.Product;

import java.util.List;

public class ProductRepository {
    private static int PAGE_SIZE = 10;
    public int getDefaultPageSize(){
        return PAGE_SIZE;
    }

    public List<Product> findAll(int page, int pageSize){
        int startPos = (page - 1) * pageSize;
        EntityManager entityManager = EntityManagerBuilder.getEntityManager();
        Query query = entityManager.createNamedQuery("PRODUCT.FIND_ALL");
        query.setFirstResult(startPos);
        query.setMaxResults(getDefaultPageSize());
        List<Product> productList = query.getResultList();
        entityManager.close();
        return productList;
    }

    public int countAll(){
        EntityManager entityManager = EntityManagerBuilder.getEntityManager();
//        parse to Number and get int value
        return ((Number) entityManager.createNamedQuery("PRODUCT.COUNT").getSingleResult()).intValue();
    }
}
