FROM openjdk:17
COPY microservice-on-kafka-server/target/microservice-on-kafka-server-1.0-SNAPSHOT-jar-with-dependencies.jar /microservice-on-kafka-server.jar
CMD ["java","-jar","/microservice-on-kafka-server.jar"]