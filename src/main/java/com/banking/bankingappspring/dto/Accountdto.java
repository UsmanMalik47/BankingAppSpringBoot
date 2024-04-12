package com.banking.bankingappspring.dto;

import lombok.Data;

@Data
public class Accountdto {
    private Long id;
    private String accountHolderName;
    private double balance;
}
