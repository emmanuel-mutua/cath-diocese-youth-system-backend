FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY build/libs/nyeriyouth.jar nyeriyouth.jar

EXPOSE 8080

CMD ["java", "-jar", "nyeriyouth.jar"]
