package com.banking.bankingappspring.controller;

import com.banking.bankingappspring.dto.Accountdto;
import com.banking.bankingappspring.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @PutMapping("/{id}/deposit")
    // Deposit Api
    public ResponseEntity<Accountdto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String,Double> request){
        Double amount= request.get("amount");
        Accountdto accountdto=accountService.deposit(id, amount);
        return ResponseEntity.ok(accountdto);
    }
    @PutMapping("/{id}/withdraw")
    // Withdraw Api

    public ResponseEntity<Accountdto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request){
        double amount = request.get("amount");
        Accountdto accountdto = accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountdto);
    }
    @GetMapping
    // Get all account api
    public ResponseEntity<List<Accountdto>> getAllAccounts(){
        List<Accountdto> accounts=accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    @DeleteMapping("/{id}")
    // Delete Account Api
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account Deleted Successfully");
    }
}
