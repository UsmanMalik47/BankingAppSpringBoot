package com.banking.bankingappspring.repository;

import com.banking.bankingappspring.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
