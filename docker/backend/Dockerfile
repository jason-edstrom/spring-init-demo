# Build Stage for Spring boot application image
FROM openjdk:11-jdk-slim as build

WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x ./mvnw
# download the dependency if needed or if the pom file is changed
RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; find ./../ -name "*.jar" -exec jar -xf {} \;)

# Run the Spring boot application
ENTRYPOINT ["java", "-cp", "app:app/lib/*","io.instacode.spring.demo.DemoApplication"]
ENTRYPOINT ["/bin/bash"]

# Production Stage for Spring boot application image
FROM openjdk:11-jre-slim as production
ARG DEPENDENCY=/app/target/dependency

# Copy the dependency application file from build stage artifact
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Run the Spring boot application
ENTRYPOINT ["java", "-cp", "app:app/lib/*","io.instacode.spring.demo.DemoApplication"]
#https://medium.com/@tariqul.islam.rony/spring-boot-and-multi-stage-dockerized-image-with-mysql-in-docker-compose-part-3-2999b2bdf6aa
