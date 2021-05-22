FROM openjdk:13
EXPOSE 8082
ADD ./target/ms-transaction-0.0.1-SNAPSHOT.jar   micro-transaction.jar
ENTRYPOINT ["java","-jar","/micro-transaction.jar"]