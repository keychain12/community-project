# Use a multi-stage build to reduce the final image size
FROM openjdk:17.0.1 as builder
WORKDIR /app
COPY build/libs/soloproject-0.0.1-SNAPSHOT.jar app.jar

# Final stage
FROM openjdk:17.0.1
WORKDIR /app
COPY --from=builder /app/app.jar app.jar
COPY src/main/webapp /app/src/main/webapp
ENTRYPOINT ["java", "-jar", "app.jar"]
