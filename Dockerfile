FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY ./target/nyeriyouth-0.0.1-SNAPSHOT.jar /app/nyeriyouth.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/nyeriyouth.jar"]
