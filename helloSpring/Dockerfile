# syntax=docker/dockerfile:1
FROM openjdk:8
COPY ./target/helloSpring-0.0.1-SNAPSHOT.jar helloSpring.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "helloSpring.jar"]