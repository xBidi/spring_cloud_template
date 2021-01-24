# Add applications to turbine server

### 1. Add the service to eureka discovery server.
````
Follow eureka module wiki
````

### 2. Add the dependencies to the pom.xml.
````
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
````

### 3. Add the annotations.
````
@EnableHystrix
@EnableCircuitBreaker
````

### 4. Add these properties to the "application.properties" file.
````
# HYSTRIX
hystrix.threadpool.default.cores-size=20
hystrix.threadpool.default.maxQueueSize=500000
hystrix.threadpool.default.keepAliveTimeMinutes=2
hystrix.threadpool.default.queueSizeRejectionThreshold=500000
hystrix.command.default.execution.timeout.enabled=false
hystrix.command.default.execution.isolation.strategy=THREAD
hystrix.command.default.execution.isolation.timeoutInMilliseconds=30000
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=16000
````

### 5. Add application to turbine properties
````
Update property: turbine.app-config
````
