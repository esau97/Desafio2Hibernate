package com.esauhp.desafio1Hibernate.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ContractDaoImpl implements ContractDaoI{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void insert(Contract contract) {
        Session session = entityManager.unwrap(Session.class);
        session.save(contract);
        session.close();
    }

    @Override
    public Contract findById(Long contractId) {
        Session session = entityManager.unwrap(Session.class);
        Contract contract = (Contract) session.createQuery("FROM Contract WHERE id="+contractId).uniqueResult();
        session.close();
        return contract;
    }

    @Override
    public void deleteContract(Contract contract) {
        entityManager.remove(entityManager.merge(contract));
    }

    @Override
    public void updateContract(Contract contract) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(contract);
        session.close();
    }

    @Override
    public List<Contract> findAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Contract> contractList;
        contractList = session.createQuery("FROM Contract").getResultList();
        session.close();
        return contractList;
    }

    @Override
    public List<Contract> findByCustomerId(Long customerId) {
        Session session = entityManager.unwrap(Session.class);
        List<Contract> contractList =  session.createQuery("FROM Contract WHERE customerId.id="+customerId).getResultList();
        session.close();
        return contractList;
    }
}
