#
# Build stage
#
#FROM maven:3.8.3-openjdk-17 AS build
#FROM maven:3.8.3-openjdk-11 AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/home/app/target/spring_docker.jar"]




# Use official OpenJDK 11 as the base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container at /app
COPY target/spring_docker.jar /app/app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Command to run the application when the container starts
CMD ["java", "-jar", "app.jar"]
