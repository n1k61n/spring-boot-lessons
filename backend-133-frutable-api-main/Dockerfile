# Build stage
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 mvn -q -e -DskipTests dependency:go-offline

COPY src ./src
RUN --mount=type=cache,target=/root/.m2 mvn -q -e -DskipTests package

# Run stage
FROM eclipse-temurin:17-jre
WORKDIR /app

# App jar name comes from pom: artifactId-version.jar
COPY --from=build /app/target/fruitables-0.0.1-SNAPSHOT.jar app.jar

ENV JAVA_OPTS=""
ENV SPRING_PROFILES_ACTIVE=prod

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]


