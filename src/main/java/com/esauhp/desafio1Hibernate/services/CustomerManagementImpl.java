package com.esauhp.desafio1Hibernate.services;

import com.esauhp.desafio1Hibernate.repository.Customer;
import com.esauhp.desafio1Hibernate.repository.CustomerDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManagementImpl implements CustomerManagementI{
    @Autowired
    private CustomerDaoI customerDaoI;

    @Override
    public void insertar(Customer customer) {
        customerDaoI.insertar(customer);
    }

    @Override
    public Customer findById(Long idCustomer) {
        Customer customer = customerDaoI.findById(idCustomer);
        return customer;
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerDaoI.deleteCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDaoI.updateCustomer(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerDaoI.findAll();
    }

    @Override
    public Customer findByName(String name, String surname1, String surname2) {
        return customerDaoI.findByName(name,surname1,surname2);
    }
}
