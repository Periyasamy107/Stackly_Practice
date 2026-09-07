package com.example.order.file.service;

import com.example.order.file.model.InvoiceData;
import com.example.order.online_order.entity.Order;

import java.io.IOException;
import java.nio.file.Path;

public interface InvoiceService {

    InvoiceData createInvoiceData(Order order);

    void serializeInvoice(InvoiceData invoiceData, Path filePath) throws IOException;

    InvoiceData deserializeInvoice(Path filePath) throws IOException, ClassNotFoundException;

    void exportInvoiceAsText(InvoiceData invoiceData, Path path) throws IOException;

    void cleanUpOldInvoices();

}
