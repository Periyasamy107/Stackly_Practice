package com.example.order.file.event;

import com.example.order.file.model.InvoiceData;
import com.example.order.file.service.InvoiceService;
import com.example.order.online_order.entity.Order;
import com.example.order.online_order.event.OrderConfirmedEvent;
import com.example.order.online_order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.io.IOException;
import java.nio.file.Path;

@Slf4j
@Component
@RequiredArgsConstructor
public class InvoiceEventListener {

    private final OrderRepository orderRepository;
    private final InvoiceService invoiceService;

    @TransactionalEventListener(
            classes = OrderConfirmedEvent.class,
            phase = TransactionPhase.AFTER_COMMIT
    )
    public void generateInvoice(OrderConfirmedEvent event) {
        try {
            Order order = orderRepository.findById(event.getOrderId())
                    .orElseThrow(() -> new IllegalArgumentException("Order not found for invoice generation : " + event.getOrderId()));
            InvoiceData invoiceData = invoiceService.createInvoiceData(order);

            Path searializedFilePath = Path.of("invoices", "order-" + order.getId() + ".ser");
            Path textFilePath = Path.of("invoices", "order-" + order.getId() + ".txt");

            invoiceService.serializeInvoice(invoiceData, searializedFilePath);
            invoiceService.exportInvoiceAsText(invoiceData, textFilePath);

            log.info("Invoice files generated successfully for the Order ID : {}", order.getId());
        } catch (IOException exception) {
            log.error("Failed to generate invoice files for Order ID : {}", event.getOrderId(), exception);
        } catch (Exception exception) {
            log.error("Unexpected error while generating invoice for Order ID : {}", event.getOrderId(), exception);
        }
    }

}
