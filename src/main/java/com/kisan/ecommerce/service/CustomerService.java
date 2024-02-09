package com.kisan.ecommerce.service;

import com.kisan.ecommerce.exception.UserNotFoundException;
import com.kisan.ecommerce.model.Customer;
import com.kisan.ecommerce.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer addCustomer(Customer customer){
        customer.setCustomerCode(UUID.randomUUID().toString());
        return customerRepo.save(customer);
    }

    public List<Customer> findAllCustomers(){
        return customerRepo.findAll();
    }

    public Customer updateCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public Customer findCusterById(Long id){
       return customerRepo.findCustomerById(id).orElseThrow(
               ()-> new UserNotFoundException("User by id "+id+" was not found"));
    }

    public void deleteCustomer(Long id){
        customerRepo.deleteCustomerById(id);
    }
}
