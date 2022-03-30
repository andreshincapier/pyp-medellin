FROM adoptopenjdk/openjdk16-openj9:alpine-slim AS compile
ARG HOME_DIR="/home-pyp"
WORKDIR $HOME_DIR
COPY ./main.gradle ./build.gradle
COPY . $HOME_DIR
RUN chmod +x $HOME_DIR/gradlew && $HOME_DIR/gradlew clean build -x test
RUN cp applications/microservice/build/libs/app-service.jar $HOME_DIR/pyp.jar
FROM adoptopenjdk/openjdk16 AS jar
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring
ARG HOME_DIR="/home-pyp"
COPY --chown=spring --from=compile $HOME_DIR/pyp.jar .
VOLUME /tmp/logs
ENTRYPOINT ["java", "-jar", "/pyp.jar"]
