echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop app-security
docker rm  app-security
echo **************************************************************
docker build -t diegosym/ms-security-v1 .
docker push  diegosym/ms-security-v1
echo **************************************************************
echo run image 
docker run -p 8010:8010 --name app-security --network aforo255-test -d diegosym/ms-security-v1
echo *************************************************************
echo End Process
echo *************************************************************