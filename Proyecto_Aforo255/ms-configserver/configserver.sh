echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop app-configserver
docker rm  app-configserver
echo **************************************************************
docker build -t diegosym/ms-configserver-v1 .
docker push  diegosym/ms-configserver-v1
echo **************************************************************
echo run image 
docker run -p 8888:8888 --name app-configserver --network aforo255-test -d diegosym/ms-configserver-v1
echo *************************************************************
echo End Process
echo *************************************************************