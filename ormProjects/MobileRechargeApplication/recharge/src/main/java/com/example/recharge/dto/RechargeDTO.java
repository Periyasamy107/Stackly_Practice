package com.example.recharge.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RechargeDTO {

    private Long rechargeId;

    @NotBlank(message = "Mobile number is required")
    @Pattern(
            regexp = "^(\\+91 )?[6-9][0-9]{9}$",
            message = "Mobile number must be a valid 10 digit number starting with 6, 7, 8 or 9, with optional +91"
    )
    private String mobileNumber;

    @NotBlank(message = "Operator is required")
    private String operator;

    @Min(value = 100, message = "Minimum recharge amount is Rs.100")
    private Double amount;

    @NotBlank(message = "Plan Type is required")
    private String planType;

}
