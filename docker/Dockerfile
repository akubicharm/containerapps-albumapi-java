# Runtime stage
FROM registry.redhat.io/ubi9/openjdk-21-runtime:latest
COPY target/containerapps-albumapi-java-1.0-SNAPSHOT.jar  ./
RUN echo $PATH
EXPOSE 8080
CMD ["/usr/bin/java", "-jar", "./containerapps-albumapi-java-1.0-SNAPSHOT.jar"]