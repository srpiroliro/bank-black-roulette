package com.tecnocampus.bank.persistence;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tecnocampus.bank.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findAllByCustomerId(String customerId);

    // Account findAny();
}
