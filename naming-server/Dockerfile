FROM openjdk:17-jdk-alpine

WORKDIR /app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose the Eureka server port (default is usually 8761)
EXPOSE 8761

ENTRYPOINT ["java", "-jar", "app.jar"]
