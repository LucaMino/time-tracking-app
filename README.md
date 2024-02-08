# time-tracking-app

### Run for compile
```console
./mvnw spring-boot:run
```

### Setup local environment
Create postgres docker image
```console
docker run --name postgres_container -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres
```

Run migration
```console
mvn flyway:migrate
```