package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Customer;

@Repository
public interface WalletRepo extends JpaRepository<Customer, String> {

	
}