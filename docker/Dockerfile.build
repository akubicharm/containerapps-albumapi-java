# Build stage
# FROM mcr.microsoft.com/openjdk/jdk:21-mariner AS build
FROM registry.redhat.io/ubi9/openjdk-21:latest AS build
COPY pom.xml pom.xml
COPY src src
RUN mvn -e package


# Runtime stage
FROM registry.redhat.io/ubi9/openjdk-21-runtime:latest
COPY --from=build $HOME/target/containerapps-albumapi-java-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["/usr/bin/java", "-jar", "./containerapps-albumapi-java-0.0.1-SNAPSHOT.jar"]