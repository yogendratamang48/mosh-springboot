package com.ytamang.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// @Service("stripe")
// @Primary
public class StripePaymentService implements PaymentService{
    @Value("${stripe.apiUrl}")
    private String apiUrl;
    @Value("${stripe.timeout-ms:3000}")
    private int timeoutMs;
    @Value("${stripe.supported-currencies}")
    private List<String> supportedCurrencies;
    @Value("${stripe.enabled}")
    private boolean enabled;
    @Override
    public void processPayment(double amount) {
        System.out.println("===STRIPE===");
        System.out.println("API URL: " + apiUrl);
        System.out.println("Timeout: " + timeoutMs);
        System.out.println("Supported Currencies: " + supportedCurrencies);
        System.out.println("Amount: " + amount);

    }
}
