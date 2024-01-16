FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8082 80
ENV URL_APLICACION_2=http://host.docker.internal:8081/eps/create
ENTRYPOINT ["java","-jar","/app.jar"]