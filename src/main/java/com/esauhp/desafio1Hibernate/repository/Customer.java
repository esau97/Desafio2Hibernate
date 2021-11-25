package com.esauhp.desafio1Hibernate.repository;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="CUSTOMER_ID")
    private Long id;

    @Getter @Setter @Column(name="NAME")
    private String name;

    @Getter @Setter @Column(name = "SURNAME1")
    private String surName1;

    @Getter @Setter @Column(name = "SURNAME2")
    private String surName2;

    @Getter @Setter @Column(name = "CUSTOMER_DNI",unique = true,length = 9)
    private String dni;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "customerId")
    @Getter @Setter
    private List<Contract> contractList;

    public Customer(){

    }

    public Customer( String name, String surName1, String surName2, String dni) {
        this.name = name;
        this.surName1 = surName1;
        this.surName2 = surName2;
        this.dni = dni;
    }
}
