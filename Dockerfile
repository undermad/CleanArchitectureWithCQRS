FROM maven:3.9 as BUILD
WORKDIR /app
COPY . .
RUN mvn clean
RUN mvn package -DskipTests -X

FROM amazoncorretto:21
COPY --from=BUILD /app/startup/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]