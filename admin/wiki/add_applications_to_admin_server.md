# Add applications to admin server

### 1. Add the service to eureka discovery server.
````
Follow eureka module wiki
````

### 2. Add these properties to the "application.properties" file.
````
# MANAGEMENT
management.endpoints.web.exposure.include=*
management.endpoint.env.post.enabled=true
````

### 3. Add the dependency to the pom.xml
````
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
    <version>2.3.3.RELEASE</version>
</dependency>
````
