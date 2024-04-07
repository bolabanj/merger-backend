FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/Merger-0.0.1-SNAPSHOT.jar Merger.jar
ENTRYPOINT ["java", "-jar", "Merger.jar"]