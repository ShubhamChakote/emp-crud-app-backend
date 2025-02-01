# Use the official Java 23 image from Docker Hub
FROM openjdk:23-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file from your local machine to the Docker container
COPY target/empcrud-0.0.1-SNAPSHOT.jar /app/empcrud.jar

# Expose the port your Spring Boot app will run on (default 8080)
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "empcrud.jar"]
