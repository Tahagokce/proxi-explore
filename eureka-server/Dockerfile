FROM openjdk:21-slim
ARG JAR_FILE=target/*.jar
COPY target/eureka-server-1.0-SNAPSHOT.jar eureka-service.jar
CMD ["java", "-jar", "eureka-service.jar"]
