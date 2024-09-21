package com.storeproceduce.service;

import com.storeproceduce.model.Customer;
import com.storeproceduce.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public boolean savePro(Customer customer) {
       return iCustomerRepository.savePro(customer);
    }
}
