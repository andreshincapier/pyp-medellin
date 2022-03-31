FROM arm64v8/openjdk:16-ea-1-jdk-slim
VOLUME /tmp
COPY *.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=" -Xshareclasses:name=cacheapp,cacheDir=/cache,nonfatal -XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar app.jar" ]