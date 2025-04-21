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
- Use @Lazy to delay bean creation.

### Bean Scopes
- Singleton scope (default)
- Prototype scope - `@Scope("prototype")`
- Request scope
- Session scope

### Bean lifecycle hooks
- `@PostConstruct`
- `@PreDestroy`

# Databases
- Database migration with flyway

## Create Domain models
- @Entity to create models
- getters, setters, constructors can be simplified using Lombok
- @Builder pattern
- Tag @Entity with @Builder
```java
var user = User.builder()
    .name("John")
    .email("john@gmail.com")
    .password("123456")
    .build();
```
- Use JPA to create entities from Database. Make sure to cleanup unnecessary stuffs.
- Create Flyway migration wherever possible.
## Generating DB with Hibernate
- Not recommended for production.
```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: create
```