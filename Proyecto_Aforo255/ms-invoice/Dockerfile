FROM openjdk:13
EXPOSE 8081
ADD ./target/ms-invoice-0.0.1-SNAPSHOT.jar   micro-invoice.jar
ENTRYPOINT ["java","-jar","/micro-invoice.jar"]