# Add applications to zuul server


## With eureka

### 1. Add the service to eureka discovery server.
````
Follow eureka module wiki
````

## Without eureka

### 1. Add these properties to zuul application.properties.
````
# without eureka
zuul.routes.{SERVICE_NAME}.path={SERVICE_PATH}/**
zuul.routes.{SERVICE_NAME}.url={SERVICE_URL}

# with eureka
zuul.routes.{SERVICE_NAME}.path={SERVICE_PATH}/**
zuul.routes.{SERVICE_NAME}.service-id={SERVICE_ID}
````

example:
````
# without eureka
zuul.routes.google.path=/api/google/**
zuul.routes.google.url=http://api.google.com/

# with eureka
zuul.routes.google.path=/api/google/**
zuul.routes.google.service-id=google
````
