#systax=docker/dockerfile:1

FROM mirror.gcr.io/library/openjdk:17-alpine

COPY target/*.jar abs-integration-service.jar

EXPOSE 10080

CMD exec java $JAVA_OPTS -jar abs-integration-service.jar
