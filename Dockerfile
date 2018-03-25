FROM openjdk:8
ADD target/skeleton_rest-0.0.1-SNAPSHOT.jar skeleton_rest-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "skeleton_rest-0.0.1-SNAPSHOT.jar"]