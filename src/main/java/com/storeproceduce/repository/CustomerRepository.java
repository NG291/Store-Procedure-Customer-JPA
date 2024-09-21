package com.storeproceduce.repository;

import com.storeproceduce.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public boolean savePro(Customer customer) {
       String queryStr = "CALL Create_Customer(:firstName,:lastName)";
        Query query = entityManager.createNativeQuery(queryStr);
            query.setParameter("firstName",customer.getFirstName());
            query.setParameter("lastName",customer.getLastName());
            return query.executeUpdate() !=0;
    }
}
