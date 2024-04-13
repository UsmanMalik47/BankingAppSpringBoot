package com.banking.bankingappspring.service;

import com.banking.bankingappspring.dto.Accountdto;

import java.util.List;

public interface AccountService {

    Accountdto createAccount(Accountdto accountdto);

    Accountdto getAccountById(Long id);
    Accountdto deposit(Long id, double amount);

    Accountdto withdraw(Long id, double amount);

    List<Accountdto> getAllAccounts();

    void deleteAccount(Long id);
}
