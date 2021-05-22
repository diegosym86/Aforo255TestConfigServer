echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop app-gateway
docker rm  app-gateway
echo **************************************************************
docker build -t diegosym/ms-gateway-v1 .
docker push  diegosym/ms-gateway-v1
echo **************************************************************
echo run image 
docker run -p 8090:8090 --name app-gateway --network aforo255-test -d diegosym/ms-gateway-v1
echo *************************************************************
echo End Process
echo *************************************************************