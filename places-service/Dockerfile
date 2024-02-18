FROM openjdk:21-slim
ARG JAR_FILE=target/*.jar
COPY target/places-service-1.0-SNAPSHOT.jar places-service.jar
CMD ["java", "-jar", "places-service.jar"]
