FROM openjdk:17-alpine

WORKDIR /app

COPY build/libs/user-management-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/app/app.jar"]
