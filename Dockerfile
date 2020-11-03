FROM openjdk:8-jdk-alpine as build

WORKDIR /app

# copy everything
COPY . .

# download the dependency if needed or if the pom file is changed
RUN ./mvnw dependency:go-offline -B

RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# Production Stage for Spring boot application image
FROM openjdk:8-jre-alpine as production

# Copy the dependency application file from build stage artifact
COPY --from=build /app/target/dependency/BOOT-INF/lib /app/lib
COPY --from=build /app/target/dependency/META-INF /app/META-INF
COPY --from=build /app/target/dependency/BOOT-INF/classes /app

# Expose PORT 8080 to the world
EXPOSE 8080

# Run the Spring boot application
ENTRYPOINT ["java", "-cp", "app:app/lib/*","mtruck.api.ApiApplication"]