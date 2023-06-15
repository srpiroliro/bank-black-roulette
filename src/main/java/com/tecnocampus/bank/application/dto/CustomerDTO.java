package com.tecnocampus.bank.application.dto;

import com.tecnocampus.bank.domain.Customer;

import java.text.SimpleDateFormat;

public class CustomerDTO {
    private final SimpleDateFormat dateFormat = Customer.dateFormat;

    private String username;
    private String email;
    private String phone;
    private String password;

    private String creationDate;

    public CustomerDTO(){ }

    public CustomerDTO(Customer costumer){
        username=costumer.getUsername();
        email=costumer.getEmail();
        phone=costumer.getPhone();
        password=costumer.getPassword();

        creationDate=dateFormat.format(costumer.getCreationDate().getTime());
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
    public String getCreationDate() {
        return creationDate;
    }
}
