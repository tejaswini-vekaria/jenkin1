FROM openjdk:8
EXPOSE 8080
ADD target/tejaswini-jenkin-assignment.jar tejaswini-jenkin-assignment.jar
ENTRYPOINT ["java","-jar","/tejaswini-jenkin-assignment.jar"]