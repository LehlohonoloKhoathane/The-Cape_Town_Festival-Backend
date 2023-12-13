# Use an official Maven image with OpenJDK 17
FROM maven:3.8.4-openjdk-17

WORKDIR /app

# Clone the repository

# Build the Spring Boot application
RUN mvn package

# Specify the path to the JAR file after building
CMD ["java", "-jar", "target/OnTheGoRentals.jar"]

LABEL authors="Lehlohonolo Khoathane"
