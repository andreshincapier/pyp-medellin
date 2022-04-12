FROM azul/zulu-openjdk:17.0.2-17.32.13-arm64 AS compile
ARG HOME_DIR="/home-pyp"
WORKDIR $HOME_DIR
COPY ./main.gradle ./build.gradle
COPY . $HOME_DIR
RUN chmod +x $HOME_DIR/gradlew
RUN cp applications/app-service/build/libs/app-service.jar $HOME_DIR/pyp.jar
FROM azul/zulu-openjdk:17.0.2-17.32.13-arm64 AS jar
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring
ARG HOME_DIR="/home-pyp"
COPY --chown=spring --from=compile $HOME_DIR/pyp.jar .
VOLUME /tmp/logs
ENTRYPOINT ["java", "-jar", "/pyp.jar"]