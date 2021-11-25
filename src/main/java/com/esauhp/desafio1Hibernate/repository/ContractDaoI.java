package com.esauhp.desafio1Hibernate.repository;

import java.util.List;

public interface ContractDaoI{
    public void insert(Contract contract);
    public Contract findById(Long contractId);
    public void deleteContract(Contract contract);
    public void updateContract(Contract contract);
    public List<Contract> findAll();
    public List<Contract> findByCustomerId(Long customerId);
}
