package com.tecnocampus.bank.domain;

import com.tecnocampus.bank.application.dto.AccountDTO;

public class Account {
    private static final String countryCode="ES";

    private String iban = generateIban();
    private double balance = 0;

    public Account(){}
    public Account(AccountDTO accountDTO){}

    private String generateIban(){
        return countryCode+String.valueOf((int) (Math.random()*Math.pow(10, 18)));
    };

    public double getBalance() {
        return balance;
    }
    public String getIban() {
        return iban;
    }
}
