FROM maven:3.9.9-eclipse-temurin-21 as builder
COPY src /tmp/src/
COPY pom.xml /tmp/
WORKDIR /tmp/
RUN mvn clean install


FROM maven:3.9.9-eclipse-temurin-21
COPY --from=builder /tmp/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]