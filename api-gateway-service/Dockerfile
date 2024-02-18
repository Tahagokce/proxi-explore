FROM openjdk:21-slim
ARG JAR_FILE=target/*.jar
COPY target/api-gateway-service-1.0-SNAPSHOT.jar api-gateway-service.jar
CMD ["java", "-jar", "api-gateway-service.jar"]

