# Add applications to eureka server

### 1. Add the dependencies to the pom.xml.
````
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
````

### 2. Add the annotation.
````
@EnableDiscoveryClient
````

### 3. Add these properties to the "application.properties" file.
````
# EUREKA
eureka.client.serviceUrl.defaultZone=${EUREKA_URI:http://localhost:8761/eureka}
````
