package com.tecnocampus.bank.domain;

import com.tecnocampus.bank.application.dto.CustomerDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;


public class Customer {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    private static final int MIN_PASS_LENTGH=8;
    private static final int MIN_PASS_NUMERIC_CHAR=1;
    private static final int MAX_ACCOUNTS=3;

    private String username;
    private String email;
    private String phone;
    private String password;

    private Calendar creationDate = Calendar.getInstance();

    private List<Account> accounts = new ArrayList<>();

    public Customer(CustomerDTO costumerDTO) throws Exception {
        username=costumerDTO.getUsername();
        email=costumerDTO.getEmail();
        phone=costumerDTO.getPhone();
        password=verifyPassword(costumerDTO.getPassword());
    }

    public void updateCustomer(CustomerDTO customerDTO) throws Exception{
        // username
        email=customerDTO.getEmail();
        phone=customerDTO.getPhone();
        password=verifyPassword(customerDTO.getPassword());
    }


    private String verifyPassword(String password) throws Exception{
        if(password.length()<MIN_PASS_LENTGH)
            throw new Exception("Password must be longer than "+MIN_PASS_LENTGH);
        
        String passwordNumericChars=password.replaceAll("[^0-9]+", password);
        if(passwordNumericChars.length()<MIN_PASS_NUMERIC_CHAR)
            throw new Exception("Password must contain atleast "+MIN_PASS_NUMERIC_CHAR+" number");
        
        return password;
    }


    public List<Account> getAccounts() {
        return accounts;
    }
    public boolean canCreateAccounts() {
        return accounts.size()<MAX_ACCOUNTS;
    }
    public void addAccount(AccountDTO accountDTO) throws Exception {
        if(!canCreateAccounts()) 
            throw new Exception("Can't create more accounts."); 
        accounts.add(new Account(accountDTO));
    }



    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getPhone() {
        return phone;
    }
    public Calendar getCreationDate() {
        return creationDate;
    }
}
