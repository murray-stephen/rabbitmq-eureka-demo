## rabbitmq-eureka-demo

The project is a mono repo Spring Boot application that has three projects.
1. eureka-microservice
2. user-management
3. user-events

The purpose of the project is to be a Spring Boot microservices demo using Eureka and RabbitMQ and is Dockerized.

### Running the application

- Ensure all projects are built with ``./gradlew build`` before starting.

#### Run with docker-compose

- docker-compose up -d --build
- docker-compose down

#### Build and run each container separately

As this is a multi-application project, a network needs to be created for the different apps.

-docker network create microservices-network

Run a RabbitMQ server before starting anything else.

- docker run -d --hostname rabbit-demo --name rabbit-demo --network microservices-network -p 8080:15672 -p 5672:5672 rabbitmq:3-management

Do a Docker build for the different applications.

- docker build --no-cache -t eureka-service .
- docker build --no-cache -t eureka-service-app .
- docker build --no-cache -t eureka-service-app .

Run the applications.

- docker run -p 8761:8761 --name eureka-service --network microservices-network eureka-service 
- docker run  -p 8081:8081 --name user-management-app --network microservices-network -e EUREKA_CLIENT_SERVICE_URL_DEFAULTZONE=http://eureka-service:8761/eureka user-management-app
- docker run -p 8090:8090 --name user-events-app --network microservices-network -e EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://eureka-service:8761/eureka user-events-app 

#### URLs

user-management /users endpoint returns a list of users from a H2 database.
A post to /users and passing in a user object will store the value in the H2 database.
When a GET request is made to /users a simple message will be published and listened to by the user-events app.

- http://localhost:8081/users

user-management Swagger interface

- http://localhost:8081/swagger-ui/index.html#/

H2 database console

- http://localhost:8081/h2-console/

RabbitMQ management console (guest/guest)

- http://localhost:8080/#/

