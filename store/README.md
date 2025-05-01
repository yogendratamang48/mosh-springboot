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
## Repositories
- Repositories -> Crud, PagingAndSorting, Jpa
- Create a package repositories and create custom repos there.
- Extend from existing repos.
## Fetching Strategies
- Eager loading and Lazy loading

## Persisting related entities
- Use `cascade = CascadeType.PERSIST`
```java
public void persistRelated() {
    var user = User.builder()
            .name("ABC")
            .email("s@abc.com")
            .password("password123#")
            .build();

    var address = Address.builder()
            .street("Konsul-Schmidt")
            .zip("28205")
            .city("Hamburg")
            .state("Hamburg")
            .build();
    // Option 1
    user.addAddress(address); // This alone does not save to address table.
    addressRepository.save(user);
    
    // Option 2 - Use `cascade = CascadeType.PERSIST` and get rid of `addressRepository.save(user);`
    
}
```

## Deleting related entities
## Query by example
```java
@Transactional
public void fetchProducts(){
    var product = new Product();
    product.setName("frying");
    var matcher = ExampleMatcher.matching()
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    var example = Example.of(product, matcher);

    var products = productRepository.findAll(example);
    products.forEach(System.out::println);


}
```

### Custom Queries

```java
import com.ytamang.store.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

// Find products whose prices are between given range and sort by name

//SQL or JPL
@Query(value = "Select * from products p where p.price between :min and :max order by p.name", nativeQuery = true)
List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max) {

}
```

```java
import com.ytamang.store.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

// Find products whose prices are between given range and sort by name

//SQL or JPL
@Query("Select p from Product p where p.price between :min and :max order by p.name")
List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max) {

}
```
## Projections
- Use DTOs
```java
// dtos/ProductSummaryDTO.java

@Getter
@AllArgsConstructor
public class ProductSummaryDTO {
    private Long id;
    private String name;

}

// repository/ProductRepository
@Query("select new com.ytamang.store.dtos.ProductSummaryDTO(p.id, p.name) from Product p where p.category=:category")
List<ProductSummaryDTO> findByCategory(@Param("category") Category category);
```
## Entity Graph
- one to many and many to one, by default uses Lazy loading
- One way to fetch would be to update fetch strategy to EAGER
- Entity graph allows us to load eagerly for a particular query
- N+1 problem because of lazy loading
## Stored procedures


