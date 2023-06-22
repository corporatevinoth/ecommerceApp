Features Used:
==================
Spring Boot Validation

Spring Boot custom Validation for Phone Number added.

Custom Exception handler added for custom Exception (CustomerNotFoundException)

Duplicate PhoneNumber deteaction.

Proxy Pattern from payment to check order exist or not.

Aggregator pattern to aggregate order details to payment details

Implemented Database per service pattern with h2 database to ensure loose coupling and independence. Each service has different db.
Example : http://localhost:8091/h2-console

slf4j logger used to print info and error logs

Circuit Breaker pattern implemented for orderservice with resillience4j

Open Api 2.0 documentation added for spingBoot 3.x
Example : http://localhost:8091/swagger-ui/index.html

Eureka server added for service regsitry

All the microservices added to service registry with Eureka client configuration



