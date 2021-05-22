# Arquitectura Propuesta
![alt text](https://github.com/diegosym86/Aforo255TestConfigServer/blob/main/Proyecto.png)

# Instalación de la infraestructura
Todos los microservicios deben ser creados bajo la RED aforo255-test

```bash
docker network create aforo255-test
```
Los servicios de Infraestructura que se deben instalar para la ejecución del proyecto son los siguientes:

## Base de Datos MYSQL

```bash
docker run -p 3307:3306  --name ms-mysql --network aforo255-test -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=db_operation -d mysql:8
```

## Base de Datos Postgres

```bash
docker run -p 5432:5432  --name ms-postgres --network aforo255-test -e POSTGRES_PASSWORD=123456 -e  POSTGRES_DB=db_invoice -d postgres:12-alpine
```

## Base de Datos SQL Server 

```bash
docker run -p 1433:1433   --name ms-sqlserver --network aforo255-test -e ACCEPT_EULA=Y -e SA_PASSWORD=1a.2b.3c.  -d mcr.microsoft.com/mssql/server:2019-CU3-ubuntu-18.04
```
## MongoDB

```bash
docker run -p 27017:27017 --network aforo255-test --name ms-mongo -d mongo
```

## Servicio de Mensajeria Kafka

```bash
docker run -p 2181:2181 -d -p 9092:9092 --name ms-kafka --network aforo255-test -e ADVERTISED_HOST=127.0.0.1  -e NUM_PARTITIONS=3 johnnypark/kafka-zookeeper
```

