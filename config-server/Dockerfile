FROM openjdk:21-slim
ARG JAR_FILE=target/*.jar
COPY target/config-server-1.0-SNAPSHOT.jar config-server.jar
CMD ["java", "-jar", "config-server.jar"]
