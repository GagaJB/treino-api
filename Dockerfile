# Etapa 1: Construção do projeto usando Maven e Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Execução do projeto
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/treino-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]