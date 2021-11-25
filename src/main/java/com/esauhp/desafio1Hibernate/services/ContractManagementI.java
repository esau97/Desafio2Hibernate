package com.esauhp.desafio1Hibernate.services;

import com.esauhp.desafio1Hibernate.repository.Contract;

import java.util.List;

public interface ContractManagementI {
    public void insert(Contract contract);
    public Contract findById(Long contractId);
    public void deleteContract(Contract contract);
    public void updateContract(Contract contract);
    public List<Contract> findAll();
    public List<Contract> findByCustomerId(Long customerId);
}
