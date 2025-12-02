## Fruitables API - Dockerized

This project includes a Dockerfile and a docker-compose.yml to run the Spring Boot API with PostgreSQL.

### Prerequisites
- Docker Desktop installed

### Quick start (docker compose)
```bash
# From project root
docker compose up -d --build

# Tail app logs
docker compose logs -f app

# Stop & remove containers
docker compose down
```

- App URL: http://localhost:8080
- PostgreSQL: localhost:5432 (db/user/password: fruitables)

### Configuration
The compose file sets runtime env vars for the app:
- SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/fruitables
- SPRING_DATASOURCE_USERNAME=fruitables
- SPRING_DATASOURCE_PASSWORD=fruitables
- SPRING_JPA_HIBERNATE_DDL_AUTO=update
- SPRING_PROFILES_ACTIVE=prod

These override values in `src/main/resources/application.properties` while running in Docker.

### Build and run with Docker only (no compose)
```bash
# Build image (multi-stage builds the JAR first)
docker build -t fruitables:latest .

# Run app container using an external Postgres
# On macOS/Windows, host.docker.internal points to your host
# Adjust credentials/URL to your DB

docker run --name fruitables-app --rm -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/fruitables \
  -e SPRING_DATASOURCE_USERNAME=fruitables \
  -e SPRING_DATASOURCE_PASSWORD=fruitables \
  fruitables:latest
```

### Clean up volumes (remove DB data)
```bash
docker compose down -v
```

### Notes
- Uses Java 17 (Temurin) and a multi-stage Maven build for smaller final images.
- Tune JVM via `JAVA_OPTS`, e.g. `-e JAVA_OPTS="-Xms256m -Xmx512m"`.
