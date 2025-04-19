# Example application
Order application that can process payments. Payments can be done using either PayPal or Stripe.
```
class -- PaypalPaymentService
class -- StripePaymentService
class -- OrderService
```

## Dependency Injection
Instead of OrderService depending on Paypal or Stripe directly, we will create an interface for payment service. We write capabilities of this interface. 
Paypal and Stripe will implement this interface. 
```
interface -- PaymentService
```
## IOC Containers
```java
var orderService = new OrderService();
orderService.setPaymentService(new PaypalPaymentService());
orderService.placeOrder();
```
- Let Spring manage the lifecycle of objects
- Can be done using Annotations. 
- Annotations - @Component, @Service, @Repository, @Controller
- Use @Service, @Primary to annotate Bean selection
- You can use @Qualifier to specify which bean to use
- @Autowired for multiple constructors