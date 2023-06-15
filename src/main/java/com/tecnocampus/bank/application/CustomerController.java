package com.tecnocampus.bank.application;

import org.springframework.stereotype.Controller;

import com.tecnocampus.bank.application.dto.CustomerDTO;
import com.tecnocampus.bank.domain.Customer;
import com.tecnocampus.bank.persistence.CustomerRepository;

@Controller
public class CustomerController {
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) throws Exception {
        Customer customer=new Customer(customerDTO);
        customerRepository.save(customer);

        return new CustomerDTO(customer);
    }        
}