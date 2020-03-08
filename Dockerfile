FROM openjdk:8-alpine
MAINTAINER Eric Lee
ADD target/test-service-*.jar app.jar
ENV JAVA_OPTS=""
CMD exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -jar app.jar

