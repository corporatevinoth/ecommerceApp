FROM openjdk:8
EXPOSE 8080
ADD target/customer.jar customer.jar
ENTRYPOINT ["java","-jar","/customer.jar"]