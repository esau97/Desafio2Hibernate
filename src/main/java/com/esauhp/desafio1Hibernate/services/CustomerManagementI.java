package com.esauhp.desafio1Hibernate.services;

import com.esauhp.desafio1Hibernate.repository.Customer;

import java.util.List;

public interface CustomerManagementI {
    public void insertar(Customer customer);
    public Customer findById(Long customer);
    public void deleteCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public List<Customer> findAll();
    public Customer findByName(String name, String surname1,String surname2);
}
