package com.tecnocampus.bank.domain;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;
import lombok.Getter;

import com.tecnocampus.bank.application.dto.AccountDTO;

@NoArgsConstructor // ???
@Getter // ???
@Entity(name="accounts")
public class Account {
    private static final String COUNTRY_CODE="ES";

    // @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    // private Long id;
    @Id
    private String id = UUID.randomUUID().toString();


    private String iban = generateIban();
    private double balance = 0;

    @ManyToOne
    private Customer customer;

    public Account(AccountDTO accountDTO, Customer customer){
        this.customer=customer;
    }

    private String generateIban(){
        return COUNTRY_CODE+String.valueOf((int) (Math.random()*Math.pow(10, 18)));
    };

    // CHECK: create 1 funciton for each action? (deposit (+), withdraw (-)) or this is enough?
    public void updateBalance(double newBalance) {
        balance=newBalance;
    }

    public String getId(){
        return id;
    }
    public double getBalance() {
        return balance;
    }
    public String getIban() {
        return iban;
    }
}
