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
# Microservicios desarrollados

- [ms-invoice](https://github.com/diegosym86/Aforo255TestConfigServer/tree/main/Proyecto_Aforo255/ms-invoice): Servicio que lista las facturas de los clientes y adicional consume los mensajes de la cola produciodos por el microservicio de pago, para poder actualizar los montos y estados de las facturas. 
- [ms-pay](https://github.com/diegosym86/Aforo255TestConfigServer/tree/main/Proyecto_Aforo255/ms-pay): Servicio que registra el pago de una factura y produce un mensaje en un topico para que sea consumido por los microservicios de facturación y transacciones.
- [ms-transaction](https://github.com/diegosym86/Aforo255TestConfigServer/tree/main/Proyecto_Aforo255/ms-transaction): Servicio que permite listar las transacciones de una factura a traves del consumo de mensajes de un topico generado por el microservicio de pago.  
- [ms-security](https://github.com/diegosym86/Aforo255TestConfigServer/tree/main/Proyecto_Aforo255/ms-security): Servicio de Seguridad a traves de una implementación de JWT.
- [ms-gateway](https://github.com/diegosym86/Aforo255TestConfigServer/tree/main/Proyecto_Aforo255/ms-gateway): Servicio que se usa como Gateway para el acceso a todos los microservicios del proyecto. 
- [ms-configserver](https://github.com/diegosym86/Aforo255TestConfigServer/tree/main/Proyecto_Aforo255/ms-configserver): Servicio que permite centralizar la configuración de cada uno de los microservicios del proyecto

## Probar Solución

Se puede obtener el enlace de la colección de Postman [aquí](https://www.postman.com/collections/d4e320c791d613923bd6) 

Puede Importar la colección de Postman desde el siguiente enlace PostmanCollection o descargar el JSON que se encuentra en el presente proyecto PostmanJSON

# Video de Presentación
Para acceder al video ingresar al siguiente Link [Video Presentación](https://www.youtube.com/watch?v=bqpGSC86-Ok)
