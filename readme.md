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
http://localhost:8091/v3/api-docs

Spring Cloud Eureka server added for service regsitry

All the microservices added to service registry with Spring Cloud Eureka client configuration

using DataJpaTest added test cases for the CRUD operations of order service.

One CI pipeline created in the git actions for the customer branch to build automatically everytime pushses the changes.
https://github.com/corporatevinoth/ecommerceApp/actions/runs/5349198940/jobs/9700075800

CI pipeline create or the customer project to push the image to docker created whenever push code to customer branch it will execute and push to docker hub
https://hub.docker.com/repository/docker/doc01062021/customer/general





