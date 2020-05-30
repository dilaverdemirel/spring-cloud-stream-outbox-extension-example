# [Spring Cloud Stream Outbox Extension](https://github.com/dilaverdemirel/spring-cloud-stream-outbox-extension) Example

This application is an example for [Spring Cloud Stream Outbox Extension](https://github.com/dilaverdemirel/spring-cloud-stream-outbox-extension).
It shows **Spring Cloud Stream Outbox Extension** how is work.

## Features

- Uses Spring Cloud Stream
- Uses in memory db
- Works with RabbitMQ

**Cloud Stream Channel Name :** stockOperationOutputChannel
**RabbitMq Exchange Name :** stock-service.operation

## Run

Before run the applications, you need a RabbitMQ instance.
```sh
docker run -d --name my-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```

You can access RabbitMQ management console over [http://localhost:15672/](http://localhost:15672/)

For run the applications;

```sh
mvn clean package
mvn spring-boot:run
```

After that, you can access payment service on http://localhost:5000/swagger-ui.html

Or you can send manually a request for payment to payment service;
```sh
curl -X POST "http://localhost:5000/payments" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"id\": \"payment-id\", \"price\": -1, \"quantity\": 1, \"stockItemId\": \"red-pen-1\"}"
```

If you want to see outbox messages;
```shell script
curl -X GET "http://localhost:5000/outbox-messages" -H "accept: */*"
``` 