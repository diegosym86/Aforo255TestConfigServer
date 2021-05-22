echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop app-invoice
docker rm  app-invoice
echo **************************************************************
docker build -t diegosym/ms-invoice-v1 .
docker push  diegosym/ms-invoice-v1
echo **************************************************************
echo run image 
docker run -p 8081:8081 --name app-invoice --network aforo255-test -d diegosym/ms-invoice-v1
echo *************************************************************
echo End Process
echo *************************************************************