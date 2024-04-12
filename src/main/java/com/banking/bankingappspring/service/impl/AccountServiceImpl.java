package com.banking.bankingappspring.service.impl;

import com.banking.bankingappspring.dto.Accountdto;
import com.banking.bankingappspring.entity.Account;
import com.banking.bankingappspring.mapper.AccountMapper;
import com.banking.bankingappspring.repository.AccountRepository;
import com.banking.bankingappspring.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Accountdto createAccount(Accountdto accountdto) {
        Account account= AccountMapper.mapToAccount(accountdto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public Accountdto getAccountById(Long id) {
        Account account=accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));
        return AccountMapper.mapToAccountDto(account);
    }
}
