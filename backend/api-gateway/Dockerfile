# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the built jar file from the target folder into the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose the port on which your microservice runs. Use an environment variable if possible.
server.port=${PORT:8080}

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
