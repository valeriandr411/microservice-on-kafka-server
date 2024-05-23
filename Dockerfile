FROM openjdk:17
COPY microservice-on-kafka-client/target/microservice-on-kafka-client-1.0-SNAPSHOT-jar-with-dependencies.jar /microservice-on-kafka-client.jar
CMD ["java","-jar","/microservice-on-kafka-client.jar"]