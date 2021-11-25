package com.esauhp.desafio1Hibernate.services;

import com.esauhp.desafio1Hibernate.repository.Contract;
import com.esauhp.desafio1Hibernate.repository.ContractDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractManagementImpl implements ContractManagementI{

    @Autowired
    private ContractDaoI contractDaoI;

    @Override
    public void insert(Contract contract) {
        contractDaoI.insert(contract);
    }

    @Override
    public Contract findById(Long contractId) {

        return contractDaoI.findById(contractId);
    }

    @Override
    public void deleteContract(Contract contract) {
        contractDaoI.deleteContract(contract);
    }

    @Override
    public void updateContract(Contract contract) {
        contractDaoI.updateContract(contract);
    }

    @Override
    public List<Contract> findAll() {

        return contractDaoI.findAll();
    }

    @Override
    public List<Contract> findByCustomerId(Long customerId) {
        return contractDaoI.findByCustomerId(customerId);
    }
}
