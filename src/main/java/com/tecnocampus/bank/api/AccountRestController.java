package com.tecnocampus.bank.api;

import com.tecnocampus.bank.application.AccountController;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

// @ ... ("/customers/{customerId}")
public class AccountRestController {
    private AccountController accountController;

    public AccountRestController(AccountController accountController){
        this.accountController=accountController;
    }

    @GetMapping("/customers/{customerId}/accounts")
    public List<AccountDTO> getCustomerAccounts(@PathVariable String customerId) throws Exception {
        return accountController.getAccountsByCustomerId(customerId);
    }
    @PostMapping("/customers/{customerId}/accounts")
    public List<AccountDTO> createAccount(@PathVariable String customerId, @RequestBody AccountDTO accountDTO) throws Exception {
        return accountController.createAccount(customerId, accountDTO);
    }

    @GetMapping("/customers/{customerId}/accounts/{accountId}")
    public List<AccountDTO> getAccount(@PathVariable String customerId, @PathVariable String accountId) throws Exception {
        return accountController.getAccount(accountId);
    }

    @DeleteMapping("/customers/{customerId}/accounts/{accountId}")
    public void deleteAccount(@PathVariable String customerId, @PathVariable String accountId) throws Exception {
        accountController.deleteAccount(accountId);
    }
}
