# Runtime stage
FROM registry.redhat.io/ubi9/openjdk-21-runtime:latest
COPY target/containerapps-albumapi-java-0.0.1-SNAPSHOT.jar  .
RUN echo $PATH
EXPOSE 8080
CMD ["/usr/bin/java", "-jar", "./containerapps-albumapi-java-0.0.1-SNAPSHOT.jar"]