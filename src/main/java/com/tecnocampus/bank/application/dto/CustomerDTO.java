package com.tecnocampus.bank.application.dto;

import com.tecnocampus.bank.domain.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CustomerDTO {
    private String id;
    private String username;
    private String email;
    private String phone;
    private String password;

    private String creationDate;

    public CustomerDTO(Customer customer){
        id=customer.getId();
        username=customer.getUsername();
        email=customer.getEmail();
        phone=customer.getPhone();
        password=customer.getPassword();

        creationDate=Customer.dateFormat.format(customer.getCreationDate().getTime());
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
