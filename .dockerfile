FROM openjdk:22
EXPOSE 8080/tcp 4043/tcp
COPY target/Polizas-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
