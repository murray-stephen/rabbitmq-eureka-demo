FROM openjdk:17-alpine

WORKDIR /app

COPY build/libs/eureka-microservice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8761

ENTRYPOINT ["java","-jar","/app/app.jar"]
