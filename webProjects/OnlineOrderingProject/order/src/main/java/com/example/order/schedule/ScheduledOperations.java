package com.example.order.schedule;

import com.example.order.file.service.InvoiceService;
import com.example.order.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScheduledOperations {

    private final InventoryService inventoryService;
    private final InvoiceService invoiceService;

    @Scheduled(fixedRate = 10000)
    public void checkLowStock() {
        log.info("Starting scheduled low-stock inventory check.....");
        inventoryService.checkLowStock();
        log.info("Scheduled low-stock inventory check completed.");
    }

    @Scheduled(cron = "0/30 * * * * *")
    public void cleanUpOldInvoices() {
        log.info("Started old-invoice cleanup scheduler......");
        invoiceService.cleanUpOldInvoices();
        log.info("Successfully clean-up old invoices.");
    }

}
