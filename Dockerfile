FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/nyeriyouth-0.0.1-SNAPSHOT.jar nyeriyouth.jar

EXPOSE 8080

CMD ["java", "-jar", "nyeriyouth.jar"]
