## publisher-consumer-mq-vehicles-service

Run apllication:

1 -

```sh
  cd docker
  docker-compose up -d
```

2 -

```sh
  bash migrate-flyway.sh jdbc:postgresql://host.docker.internal:5432/auto_maia_cli auto_maia_cli auto_maia_cli
```

3 - 
```sh
mvn package
java -jar target/publisher-consumer-mq-vehicles-service-0.0.1-SNAPSHOT.jar
```

curl of exemple to put:

```bash
curl --location --request POST 'http://localhost:8080/api/publisher-consumer-mq-vehicles-service/v1/vehicles' \
--header 'Content-Type: application/json' \
--data-raw '{
    "marca": "Audi",
    "modelo": "AUDI A3",
    "disponivel": true
}'
```

## TO DO
- [ ] Config retry and dlq 
- [ ] Add unit tests
- [ ] Add JWT Authentication

## Technologies

- Java 11
- Spring Boot (com Spring Web MVC, Spring Data JPA)
- Banco de dados de sua preferencia (PostgreSQL/MySQL ())
- Spring Maven
- Docker
- Junit
- Log4j
- RabbitMQ
- Swagger

