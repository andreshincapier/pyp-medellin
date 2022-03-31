FROM arm64v8/openjdk:16-ea-1-jdk-slim as compile
ARG HOME_DIR="/home-pyp"
WORKDIR $HOME_DIR
COPY ./main.gradle ./build.gradle
COPY . $HOME_DIR
RUN chmod +x $HOME_DIR/gradlew && $HOME_DIR/gradlew clean build -x test
RUN cp applications/app-service/build/libs/app-service.jar $HOME_DIR/pyp.jar
FROM arm64v8/openjdk:16 AS jar
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring
ARG HOME_DIR="/home-pyp"
COPY --chown=spring --from=compile $HOME_DIR/pyp.jar .
VOLUME /tmp/logs
ENTRYPOINT ["java", "-jar", "/pyp.jar"]
