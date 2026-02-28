# ---- Build stage ----
FROM eclipse-temurin:25-jdk AS build
WORKDIR /app

# Copy everything (including gradlew)
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts ./

RUN chmod +x gradlew
RUN ./gradlew dependencies --no-daemon

# 2️⃣ Copy source code later
COPY src src

RUN ./gradlew clean bootJar -x test --no-daemon

# ---- Runtime stage ----
FROM eclipse-temurin:25-jre
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]