package com.esauhp.desafio1Hibernate.repository;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_CONTRACT")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="CONTRACT_ID")
    private Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "yyyy-mm-dd")
    @Getter @Setter @Column(name="DATE")
    private Date date;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "yyyy-mm-dd")
    @Getter @Setter @Column(name="EXPIRATION_DATE")
    private Date expirationDate;

    @Getter @Setter @Column(name="PRICE")
    private Double price;

    @ManyToOne (fetch = FetchType.LAZY)
    //@OnDelete(action = OnDeleteAction.CASCADE) // Al eliminar un cliente se eliminan todos sus contratos
    @Getter @Setter @JoinColumn(name="CUSTOMER_ID")
    private Customer customerId;

    public Contract(){

    }

    public Contract(Date date, Date expirationDate, Double price, Customer customerId) {
        this.date = date;
        this.expirationDate = expirationDate;
        this.price = price;
        this.customerId = customerId;
    }
}
