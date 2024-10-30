FROM eclipse-temurin:21-jdk-alpine
MAINTAINER "Dibyendu Rakshit"

# Create a non-root user and set the working directory
RUN adduser -D springuser
WORKDIR /app

# Copy the JAR file to the container
COPY target/*.jar app.jar

# Change the ownership of the jar file
RUN chown springuser:springuser app.jar

# Switch to the non-root user
USER springuser

# Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
