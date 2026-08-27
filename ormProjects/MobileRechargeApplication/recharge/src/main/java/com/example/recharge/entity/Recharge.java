package com.example.recharge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "basic_recharges")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Recharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rechargeId;

    @Column(nullable = false, unique = true)
    private String mobileNumber;

    @Column(nullable = false)
    private String operator;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String planType;

}
