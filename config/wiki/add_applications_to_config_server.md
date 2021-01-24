# Add applications to config server

### 1. Add dependencies to the pom.xml.
````
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
````

### 2. Rename the properties file.
````
"application.properties" to "bootstrap.properties"
````

### 3. Add these properties to the file "bootstrap.properties".
````
# SPRING
spring.application.name=${SERVICE_NAME}
spring.profiles.active=${PROFILE}

# SPRING CONFIG
spring.cloud.config.uri=${CONFIG_SERVER_URI:http://localhost:8763}
spring.cloud.config.fail-fast=true
````
