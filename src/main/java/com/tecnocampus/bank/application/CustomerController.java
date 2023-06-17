package com.tecnocampus.bank.application;

import java.util.List;
import java.util.stream.Collectors;
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


    public List<CustomerDTO> getAllCustomers() throws Exception {
        return customerRepository.findAll()
                                    .stream()
                                    .map(CustomerDTO::new)
                                    .collect(Collectors.toList());
    }
    
    public CustomerDTO getCustomer(String customerId) throws Exception {
        return new CustomerDTO(customerRepository.findById(customerId).get());
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) throws Exception {
        Customer customer=new Customer(customerDTO);
        customerRepository.save(customer);

        return new CustomerDTO(customer);
    }

    public CustomerDTO updateCustomer(String customerId, CustomerDTO customerDTO) throws Exception {
        Customer customer = customerRepository.findById(customerId).get();

        customer.updateCustomer(customerDTO);
        customerRepository.save(customer);

        return new CustomerDTO(customer);
    }

    public void deleteCustomer(String customerId){
        customerRepository.deleteById(customerId);
    }
}