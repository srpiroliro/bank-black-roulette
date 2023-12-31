package com.tecnocampus.bank.api;

import com.tecnocampus.bank.application.CustomerController;
import com.tecnocampus.bank.application.dto.CustomerDTO;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
public class CustomerRestController {
    private CustomerController customerController;

    public CustomerRestController(CustomerController customerController){
        this.customerController=customerController;
    }


    @GetMapping("/customers")
    public List<CustomerDTO> getAllCustomers() throws Exception {
        return customerController.getAllCustomers();
    }

    @PostMapping("/customers")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) throws Exception {
        return customerController.createCustomer(customerDTO);
    }



    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable String id) throws Exception {
        return customerController.getCustomer(id);
    }

    @PutMapping("/customers/{id}")
    public CustomerDTO updateCustomer(@PathVariable String id, @RequestBody CustomerDTO customerDTO) throws Exception {
        return customerController.updateCustomer(id, customerDTO);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable String id) throws Exception {
        customerController.deleteCustomer(id);
    }   
}