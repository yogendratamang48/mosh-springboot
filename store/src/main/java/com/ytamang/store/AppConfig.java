package com.ytamang.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {
    @Value("${payment.method:stripe}")
    private String paymentMethod;
    @Bean
    @Lazy
    public PaymentService stripe() {
        System.out.println("Payment Stripe created!");
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal() {
        return new PaypalPaymentService();
    }

    @Bean
    public OrderService orderService() {
        if (paymentMethod.equals("paypal")) {
            return new OrderService(paypal());
        }
        return new OrderService(stripe());
    }

}
