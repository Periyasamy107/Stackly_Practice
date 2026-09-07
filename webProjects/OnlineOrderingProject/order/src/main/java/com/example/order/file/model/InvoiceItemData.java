package com.example.order.file.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItemData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long orderItemId;
    private Long productId;
    private String productName;
    private Integer quantity;
    private BigDecimal productPrice;
    private BigDecimal totalPrice;

}
