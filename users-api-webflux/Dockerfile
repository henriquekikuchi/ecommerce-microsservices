###### BUILD
FROM openjdk:17-alpine as build

WORKDIR /app/build

COPY mvnw pom.xml ./
COPY .mvn .mvn

RUN ./mvnw -B dependency:go-offline

COPY src/ ./src/

RUN ./mvnw package

###### RUN
FROM openjdk:17-alpine

WORKDIR /app/run

COPY --from=build /app/build/target/*.jar ./app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]