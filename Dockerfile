FROM openjdk:8
EXPOSE 8080
ADD target/productcatalog.jar productcatalog.jar
ENTRYPOINT ["java","-jar","/productcatalog.jar"]