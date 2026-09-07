package com.example.order.file.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long orderId;
    private Long customerId;
    private String customerUserName;
    private List<InvoiceItemData> items;
    private Integer totalItems;
    private BigDecimal totalAmount;
    private String orderStatus;
    private LocalDateTime orderDate;
    private String createdBy;
    private LocalDateTime lastModifiedDate;
    private String lastModifiedBy;
    private Long version;


}
