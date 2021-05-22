echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop app-transaction
docker rm  app-transaction
echo **************************************************************
docker build -t diegosym/ms-transaction-v1 .
docker push  diegosym/ms-transaction-v1
echo **************************************************************
echo run image 
docker run -p 8082:8082 --name app-transaction --network aforo255-test -d diegosym/ms-transaction-v1
echo *************************************************************
echo End Process
echo *************************************************************