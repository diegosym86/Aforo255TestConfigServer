FROM openjdk:13
EXPOSE 8006
ADD ./target/ms-pay-0.0.1-SNAPSHOT.jar   micro-pay.jar
ENTRYPOINT ["java","-jar","/micro-pay.jar"]