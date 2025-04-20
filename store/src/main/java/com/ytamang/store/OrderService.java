package com.ytamang.store;


// @Service
public class OrderService {
    private PaymentService paymentService;

    // Constructor
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.processPayment(10);
    }
    
    // setter
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
