package com.esauhp.desafio1Hibernate.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDaoI{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void insertar(Customer customer) {
        Session session = entityManager.unwrap(Session.class);
        session.save(customer);
        session.close();
    }

    @Override
    public Customer findById(Long idCostumer) {
        Session session = entityManager.unwrap(Session.class);
        Customer cliente = (Customer) session.createQuery("FROM Customer WHERE id="+idCostumer).uniqueResult();

        session.close();
        return cliente;
    }

    @Override
    public void deleteCustomer(Customer customer) {
        entityManager.remove(entityManager.merge(customer));
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(customer);
        session.close();
    }

    @Override
    public List<Customer> findAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Customer> customerList;
        customerList = session.createQuery("FROM Customer").getResultList();
        session.close();
        return customerList;
    }
    @Override
    public Customer findByName(String name, String surname1, String surname2) {
        Session session = entityManager.unwrap(Session.class);
        Customer customer = (Customer) session.createQuery("FROM Customer WHERE name='"+name+"' AND surName1='"+surname1+"' AND surName2='"+surname2+"'").uniqueResult();
        session.close();
        return customer;
    }


}
