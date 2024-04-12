package com.banking.bankingappspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Accountdto {
    private Long id;
    private String accountHolderName;
    private double balance;
}
