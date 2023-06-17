package com.tecnocampus.bank.application;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;

import com.tecnocampus.bank.domain.Account;
import com.tecnocampus.bank.domain.Customer;
import com.tecnocampus.bank.application.dto.AccountDTO;
import com.tecnocampus.bank.persistence.AccountRepository;
import com.tecnocampus.bank.persistence.CustomerRepository;

@Controller
public class AccountController {
    private static final double MAX_AMOUNT=50_000;

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    public AccountController(AccountRepository accountRepository, CustomerRepository customerRepository){
        this.accountRepository=accountRepository;
        this.customerRepository=customerRepository;
    }

    public AccountDTO getAccount(String accountId) {
        return new AccountDTO(accountRepository.findById(accountId).get());
    }

    public List<AccountDTO> getAccountsByCustomerId(String customerId) {
        Customer customer=customerRepository.findById(customerId).get();
        return customer.getAccounts().stream()
                                    .map(AccountDTO::new)
                                    .collect(Collectors.toList()); 
    }

    public AccountDTO createAccount(String customerId, AccountDTO accountDTO) throws Exception {
        Customer customer=customerRepository.findById(customerId).get();
        Account account=new Account(accountDTO, customer);

        customer.addAccount(account);

        accountRepository.save(account);
        customerRepository.save(customer);

        return new AccountDTO(account);
    }
    
    public void deleteAccount(String accountId){
        accountRepository.deleteById(accountId);
    }



    public AccountDTO balanceRoulette(String customerId, String accountId) throws Exception {
        Account account=accountRepository.findById(accountId).get();

        account.updateBalance(generateBalance());
        accountRepository.save(account);

        return new AccountDTO(account);
    }
    private double generateBalance(){
        return Math.random()*MAX_AMOUNT*2-MAX_AMOUNT;
    }


    public AccountDTO swap(String customerId, String accountId) throws Exception {
        Account account=accountRepository.findById(accountId).get();
        Account accountRandom=getRandomAccount(); // CHECK: too pricey?

        double balance=account.getBalance();
        double balanceRandom=accountRandom.getBalance();

        account.updateBalance(balanceRandom);
        accountRandom.updateBalance(balance);

        accountRepository.save(account);
        accountRepository.save(accountRandom);

        return new AccountDTO(account);
    }

    private Account getRandomAccount() throws Exception{
        return accountRepository.findAll().stream().findAny().get(); // CHECK: too pricey?
    }
}
