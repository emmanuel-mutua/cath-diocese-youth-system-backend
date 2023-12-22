FROM openjdk:21
WORKDIR /app
COPY target/nyeriyouth-0.0.1-SNAPSHOT.jar nyeriyouth.jar
EXPOSE 8080
CMD ["java", "-jar", "nyeriyouth.jar"]
