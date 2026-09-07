package com.example.order.file.service.impl;

import com.example.order.common.util.FileUtility;
import com.example.order.file.model.InvoiceData;
import com.example.order.file.model.InvoiceItemData;
import com.example.order.file.service.InvoiceService;
import com.example.order.online_order.entity.Order;
import com.example.order.online_order.entity.OrderItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Value("${app.file.invoice-directory:invoices}")
    private String invoiceDirectory;

    @Value("${app.file.invoice-retention-seconds:20}")
    private long invoiceRetentionSeconds;

    @Override
    public InvoiceData createInvoiceData(Order order) {
        if(order==null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        List<InvoiceItemData> items = order.getOrderItems()
                .stream().map(this::convertItem)
                .collect(Collectors.toList());

        int totalItems = order.getOrderItems().stream().mapToInt(OrderItem::getQuantity).sum();

        return InvoiceData.builder()
                .orderId(order.getId())
                .customerId(order.getCustomer()!=null ? order.getCustomer().getId() : null)
                .customerUserName(order.getCustomer()!=null ? order.getCustomer().getUserName() : null)
                .items(items)
                .totalItems(totalItems)
                .totalAmount(order.getTotalAmount())
                .orderStatus(order.getStatus()!=null ? order.getStatus().name() : null)
                .orderDate(order.getCreatedDate())
                .createdBy(order.getCreatedBy())
                .lastModifiedDate(order.getLastModifiedDate())
                .lastModifiedBy(order.getLastModifiedBy())
                .version(order.getVersion())
                .build();
    }

    @Override
    public void serializeInvoice(InvoiceData invoiceData, Path filePath) throws IOException {
        if(invoiceData==null) {
            throw new IllegalArgumentException("Invoice cannot be null");
        }
        FileUtility.serialize(invoiceData, filePath);
    }

    @Override
    public InvoiceData deserializeInvoice(Path filePath) throws IOException, ClassNotFoundException {
        return FileUtility.deserialize(filePath, InvoiceData.class);
    }

    @Override
    public void exportInvoiceAsText(InvoiceData invoiceData, Path path) throws IOException {

        if(invoiceData==null) {
            throw new IllegalArgumentException("Invoice data cannot be null");
        }

        StringBuilder invoice = new StringBuilder();

        invoice.append("==================================================").append(System.lineSeparator());
        invoice.append("           ORDER INVOICE").append(System.lineSeparator());
        invoice.append("==================================================").append(System.lineSeparator());

        invoice.append("Order ID       : ").append(invoiceData.getOrderId()).append(System.lineSeparator());
        invoice.append("Customer ID    : ").append(invoiceData.getCustomerId()).append(System.lineSeparator());
        invoice.append("Customer Name  : ").append(invoiceData.getCustomerUserName()).append(System.lineSeparator());
        invoice.append("Order Status   : ").append(invoiceData.getOrderStatus()).append(System.lineSeparator());
        invoice.append("Order Date     : ").append(invoiceData.getOrderDate()).append(System.lineSeparator());

        invoice.append("--------------------------------------------------").append(System.lineSeparator());

        for(InvoiceItemData item : invoiceData.getItems()) {

            invoice.append("Product ID     : ").append(item.getProductId()).append(System.lineSeparator());
            invoice.append("Product Name   : ").append(item.getProductName()).append(System.lineSeparator());
            invoice.append("Quantity       : ").append(item.getQuantity()).append(System.lineSeparator());
            invoice.append("Product Price  : ").append(item.getProductPrice()).append(System.lineSeparator());
            invoice.append("Total Price    : ").append(item.getTotalPrice()).append(System.lineSeparator());

            invoice.append("--------------------------------------------------").append(System.lineSeparator());

        }

        invoice.append("Total Items    : ").append(invoiceData.getTotalItems()).append(System.lineSeparator());
        invoice.append("Total Amount   : ").append(invoiceData.getTotalAmount()).append(System.lineSeparator());

        invoice.append("==================================================").append(System.lineSeparator());

        FileUtility.writeText(invoice.toString(), path);

    }

    @Override
    public void cleanUpOldInvoices() {

        Path invoiceDirectoryPath = Paths.get(invoiceDirectory);

        if(!Files.exists(invoiceDirectoryPath)) {
            log.info("Invoice directory does not exist. Nothing to clean : {}", invoiceDirectoryPath.toAbsolutePath());
            return;
        }

        if(!Files.isDirectory(invoiceDirectoryPath)) {
            log.warn("Invoice path is not a directory : {}", invoiceDirectoryPath.toAbsolutePath());
            return;
        }

        Instant cutOffTime = Instant.now().minus(invoiceRetentionSeconds, ChronoUnit.SECONDS);
        log.info("Starting invoice cleanup. Directory : {}, Retention : {} seconds", invoiceDirectoryPath.toAbsolutePath(), invoiceRetentionSeconds);

        int deletedFiles = 0;

        try(Stream<Path> files = Files.list(invoiceDirectoryPath)) {
            for(Path file : files.filter(Files::isRegularFile).filter(this::isInvoiceFile).toList()) {
                try{
                    FileTime lastModifiedTime = Files.getLastModifiedTime(file);
                    if(lastModifiedTime.toInstant().isBefore(cutOffTime)) {
                        Files.deleteIfExists(file);
                        deletedFiles++;
                        log.info("Old invoice file deleted : {}", file.toAbsolutePath());
                    }
                } catch (IOException exception) {
                    log.error("Failed to delete invoice file : {}", file.toAbsolutePath(), exception);
                }
            }
        } catch (IOException exception) {
            log.error("Failed to scan the invoice directory : {}", invoiceDirectoryPath.toAbsolutePath(), exception);
        }

        log.info("Invoice cleanup completed. {} old invoice file(s) deleted.", deletedFiles);

    }

    private boolean isInvoiceFile(Path file) {
        String fileName = file.getFileName().toString().toLowerCase();
        return fileName.startsWith("order-") && (fileName.endsWith(".ser") || fileName.endsWith(".txt"));
    }

    private InvoiceItemData convertItem(OrderItem item) {
        return InvoiceItemData.builder()
                .orderItemId(item.getId())
                .productId(item.getProduct()!=null ? item.getProduct().getId() : null)
                .productName(item.getProduct()!=null ? item.getProduct().getName() : null)
                .quantity(item.getQuantity())
                .productPrice(item.getProductPrice())
                .totalPrice(item.getTotalPrice())
                .build();
    }

}
