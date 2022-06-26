## publisher-consumer-mq-vehicles-service

1 -

```sh
  cd docker
  docker-compose up -d
```

2 -

```sh
  bash migrate-flyway.sh jdbc:postgresql://host.docker.internal:5432/auto_maia_cli auto_maia_cli auto_maia_cli
```

