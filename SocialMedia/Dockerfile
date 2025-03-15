# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory (optional)
WORKDIR /app

# Copy the jar file built by Maven into the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose the port your application uses (default is 7010 as set in application.properties)
EXPOSE 7010

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
