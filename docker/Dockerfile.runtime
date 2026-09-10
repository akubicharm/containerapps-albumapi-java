# Runtime stage
FROM registry.redhat.io/ubi9/openjdk-17-runtime:latest
COPY target/containerapps-albumapi-java-0.0.1-SNAPSHOT.jar  .

EXPOSE 8080
CMD ["/usr/bin/java", "-jar", "./containerapps-albumapi-java-0.0.1-SNAPSHOT.jar"]
