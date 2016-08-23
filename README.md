# Microservices-example
Microservices Example using Spring Cloud

Quick Microservices Bootstraping on your local machine.

Pre-requites :-
 <br> 1)  Maven 3.0+</br>
 <br> 2)  JDK/JRE 1.8+</br>
  
This example covers following functionalties :-
  <br>1)  Creating Rest full services using Spring boot.</br>
  <br>2)  ServiceRegistry using Eureka.</br>
  <br>3)  Hysterix, Ribbon enabled feign client.</br>
  
Simply import the project in your IDE and build the parent pom.

Start each of the module using maven command <strong><i>mvn spring-boot:run</i></strong>

Embedded Tomcat port has been changed in order to make it run on a single machine

In order to test load balancing EmployeeRest and EmployeeRestSecond module are registered to Eureka server with same name  <strong><i>employee-service</i></strong> in bootstrap.yml file


  
  
  

