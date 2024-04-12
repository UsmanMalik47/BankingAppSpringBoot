package com.banking.bankingappspring.controller;

import com.banking.bankingappspring.dto.Accountdto;
import com.banking.bankingappspring.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    // Add Account REST Api
    @PostMapping
    public ResponseEntity<Accountdto> addAccount(@RequestBody Accountdto accountdto){
        return new ResponseEntity<>(accountService.createAccount(accountdto), HttpStatus.CREATED);
    }

    // Get Account REST Api
    @GetMapping("/{id}")
    public ResponseEntity<Accountdto> getAccountbyId(@PathVariable Long id){
        Accountdto accountdto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountdto);
    }
}
