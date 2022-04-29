#Use Maven in the Build Stage
FROM maven:3.6.0-jdk-11-slim AS build

COPY src /app/src
COPY pom.xml /app/pom.xml

RUN mvn -f /app/pom.xml clean package

#Use OpenJDK 8 in the Packaging Stage
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080