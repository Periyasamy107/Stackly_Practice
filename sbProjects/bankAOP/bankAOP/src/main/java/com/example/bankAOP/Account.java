package com.example.bankAOP;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Account {
    private int accountNumber;
    private String name;
    private double balance;
}
