package com.tecnocampus.bank.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecnocampus.bank.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
