Note
=========
Each branch is a separate microservice. 
In the doc branch, the postman collection for each project is there.
The request payload for each project is also there in the docs branch. 
Features Used:
==================
Spring Boot Validation

Spring Boot custom Validation for Phone Number added.

Custom Exception handler added for custom Exception (CustomerNotFoundException)

Duplicate PhoneNumber detection.

Proxy Pattern from payment to check order exists or not.

Aggregator pattern to aggregate order details to payment details

Implemented Database per service pattern with h2 database to ensure loose coupling and independence. Each service has a different db.
Example: http://localhost:8091/h2-console

slf4j logger used to print info and error logs

Circuit Breaker pattern implemented for order service with resillience4j

Open Api 2.0 documentation added for spingBoot 3.x
Example: http://localhost:8091/swagger-ui/index.html
http://localhost:8091/v3/api-docs

Spring Cloud Eureka server added for service registry

Spring Cloud API gateway used for Gateway service pattern and load balancing.

All the microservices added to the service registry with Spring Cloud Eureka client configuration

using DataJpaTest added test cases for the CRUD operations of order service.

One CI pipeline was created in the git actions for the customer branch to build automatically every time pushes the changes.
https://github.com/corporatevinoth/ecommerceApp/actions/runs/5349198940/jobs/9700075800

CI pipeline create or the customer project to push the image to docker created whenever push code to customer branch it will execute and push to docker hub
https://hub.docker.com/repository/docker/doc01062021/customer/general

Webclient is used to communicate payment service to order service.

Zipkin integration for distributed log tracing thilable ate logs available after instal the zipkin clint in local machine in the url 
http://127.0.0.1:9411/zipkin
the zipkin client installation refer this documentation
https://zipkin.io/pages/tracers_instrumentation.html









