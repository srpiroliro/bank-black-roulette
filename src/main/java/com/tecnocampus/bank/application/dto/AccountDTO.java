package com.tecnocampus.bank.application.dto;

import com.tecnocampus.bank.domain.Account;

public class AccountDTO {
    private String id;
    private String iban;
    private double balance;

    public AccountDTO(){}
    public AccountDTO(Account account){
        iban=account.getIban();
        balance=account.getBalance();
        id=account.getId();
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
